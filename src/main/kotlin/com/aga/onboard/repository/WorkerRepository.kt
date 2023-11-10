package com.aga.onboard.repository

import com.aga.onboard.model.common.WorkerDto
import com.aga.onboard.tables.daos.WorkerDao
import com.aga.onboard.tables.references.WORKER
import org.jooq.Configuration
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class WorkerRepository(configuration: Configuration) : WorkerDao(configuration) {
    fun getWorkerById(id: UUID): WorkerDto =
        ctx().select(WORKER.ID.`as`("worker_id"), WORKER.NAME.`as`("worker_name"))
            .from(WORKER)
            .where(WORKER.ID.eq(id))
            .fetchOneInto(WorkerDto::class.java) ?: throw NoSuchElementException()

    fun getHeadByWorkerId(id: UUID): UUID =
        ctx().select(WORKER.HEAD_ID)
            .from(WORKER)
            .where(WORKER.ID.eq(id))
            .fetchOne()
            ?.value1() ?: throw NoSuchElementException()

    fun getHrByWorkerId(id: UUID): UUID =
        ctx().select(WORKER.HR_ID)
            .from(WORKER)
            .where(WORKER.ID.eq(id))
            .fetchOne()
            ?.value1() ?: throw NoSuchElementException()

    fun getHeadWorkersId(headId: UUID): List<UUID> =
        ctx().select()
            .from(WORKER)
            .where(WORKER.HEAD_ID.eq(headId))
            .fetch()
            .getValues(WORKER.ID)
            .requireNoNulls()

    fun getHrWorkersId(hrId: UUID): List<UUID> =
        ctx().select()
            .from(WORKER)
            .where(WORKER.HR_ID.eq(hrId))
            .fetch()
            .getValues(WORKER.ID)
            .requireNoNulls()
}
