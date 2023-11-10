package com.aga.onboard.service.internal

import com.aga.onboard.enums.Recommender
import com.aga.onboard.model.common.RecommenderDto
import com.aga.onboard.model.common.WorkerDto
import com.aga.onboard.repository.WorkerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkerService(
    val workerRepository: WorkerRepository,
) {
    fun getWorkerById(id: UUID): WorkerDto =
        workerRepository.getWorkerById(id)

    fun getRecommenderByType(recommenderType: Recommender, workerId: UUID): RecommenderDto? =
        when (recommenderType) {
            Recommender.HEAD ->
                workerRepository
                    .getHeadByWorkerId(workerId).let {
                        workerRepository.getWorkerById(it)
                    }
            Recommender.HR ->
                workerRepository
                    .getHrByWorkerId(workerId).let {
                        workerRepository.getWorkerById(it)
                    }
            else -> null
        }.let {
            RecommenderDto(recommenderType, it)
        }

    fun getHeadWorkersId(headId: UUID) = workerRepository.getHeadWorkersId(headId)
    fun getHrWorkersId(hrId: UUID) = workerRepository.getHrWorkersId(hrId)
}
