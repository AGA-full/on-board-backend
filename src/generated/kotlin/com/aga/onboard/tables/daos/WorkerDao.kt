/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables.daos


import com.aga.onboard.tables.Worker
import com.aga.onboard.tables.records.WorkerRecord

import java.util.UUID

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl


/**
 * Информация о сотрудниках
 */
@Suppress("UNCHECKED_CAST")
open class WorkerDao(configuration: Configuration?) : DAOImpl<WorkerRecord, com.aga.onboard.tables.pojos.Worker, UUID>(Worker.WORKER, com.aga.onboard.tables.pojos.Worker::class.java, configuration) {

    /**
     * Create a new WorkerDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: com.aga.onboard.tables.pojos.Worker): UUID? = o.id

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    fun fetchById(vararg values: UUID): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.ID, *values)

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    fun fetchOneById(value: UUID): com.aga.onboard.tables.pojos.Worker? = fetchOne(Worker.WORKER.ID, value)

    /**
     * Fetch records that have <code>username BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfUsername(lowerInclusive: String?, upperInclusive: String?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.USERNAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    fun fetchByUsername(vararg values: String): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.USERNAME, *values)

    /**
     * Fetch records that have <code>company_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfCompanyId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.COMPANY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>company_id IN (values)</code>
     */
    fun fetchByCompanyId(vararg values: UUID): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.COMPANY_ID, *values)

    /**
     * Fetch records that have <code>password BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfPassword(lowerInclusive: String?, upperInclusive: String?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.PASSWORD, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    fun fetchByPassword(vararg values: String): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.PASSWORD, *values)

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfName(lowerInclusive: String?, upperInclusive: String?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    fun fetchByName(vararg values: String): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.NAME, *values)

    /**
     * Fetch records that have <code>team_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfTeamId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.TEAM_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>team_id IN (values)</code>
     */
    fun fetchByTeamId(vararg values: UUID): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.TEAM_ID, *values)

    /**
     * Fetch records that have <code>head_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfHeadId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.HEAD_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>head_id IN (values)</code>
     */
    fun fetchByHeadId(vararg values: UUID): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.HEAD_ID, *values)

    /**
     * Fetch records that have <code>hr_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfHrId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Worker> = fetchRange(Worker.WORKER.HR_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>hr_id IN (values)</code>
     */
    fun fetchByHrId(vararg values: UUID): List<com.aga.onboard.tables.pojos.Worker> = fetch(Worker.WORKER.HR_ID, *values)
}
