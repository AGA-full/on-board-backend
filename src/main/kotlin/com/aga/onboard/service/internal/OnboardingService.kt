package com.aga.onboard.service.internal

import com.aga.onboard.model.common.OnboardingBlock
import com.aga.onboard.model.common.OnboardingDto
import com.aga.onboard.model.internal.OnboardingBlockRaw
import com.aga.onboard.model.internal.OnboardingDtoRaw
import com.aga.onboard.repository.OnboardingRepository
import com.aga.onboard.usecase.application.MainPageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class OnboardingService(
    val onboardingRepository: OnboardingRepository,
    val workerService: WorkerService,
) {
    enum class OnboardingGroup {
        NOW, RECOMMENDED, NEW,
        AUTHOR, INSTRUCTOR
    }

    fun getOnboardingList(workerId: UUID, vararg groups: OnboardingGroup): List<OnboardingBlock> =
        groups.map { onboardingGroup ->
            when (onboardingGroup) {
                OnboardingGroup.NOW -> OnboardingBlockRaw(
                    title = "Проходите сейчас",
                    onboardings = getCurrentOnboardings(
                        workerId = workerId,
                    ),
                )

                OnboardingGroup.RECOMMENDED -> OnboardingBlockRaw(
                    title = "Рекомендовано",
                    onboardings = getRecommendedOnboardings(
                        workerId = workerId,
                    ),
                )

                OnboardingGroup.NEW -> OnboardingBlockRaw(
                    title = "Можно погрузиться",
                    onboardings = getInterestingOnboardings(),
                )

                OnboardingGroup.INSTRUCTOR -> OnboardingBlockRaw(
                    title = "Инструктор",
                    onboardings = getInstructorOnboardings(
                        workerId = workerId,
                    ),
                )

                OnboardingGroup.AUTHOR -> OnboardingBlockRaw(
                    title = "Автор",
                    onboardings = getAuthoredOnboardings(
                        workerId = workerId,
                    ),
                )
            }.let { rawBlock ->
                OnboardingBlock(
                    title = rawBlock.title,
                    onboardings = rawBlock.onboardings.map { it.toOnboardingDto(workerId) },
                )
            }
        }

    private fun getAuthoredOnboardings(workerId: UUID): List<OnboardingDtoRaw> =
        onboardingRepository.getAuthoredOnboardings(workerId)

    private fun getInstructorOnboardings(workerId: UUID): List<OnboardingDtoRaw> =
        onboardingRepository.getInstructorOnboardings(workerId)

    private fun getInterestingOnboardings(): List<OnboardingDtoRaw> = emptyList()

    private fun getRecommendedOnboardings(workerId: UUID): List<OnboardingDtoRaw> =
        onboardingRepository.getRecommendedOnboardings(workerId)

    private fun getCurrentOnboardings(workerId: UUID): List<OnboardingDtoRaw> =
        onboardingRepository.getCurrentOnboardings(workerId)

    fun getHeadOnboardings(workerId: UUID): List<OnboardingBlock> =
        onboardingRepository.getOnboardingsByWorkersId(
            workerService.getHeadWorkersId(workerId),
        ).map { workerOnboardings ->
            OnboardingBlock(
                title = workerService.getWorkerById(workerOnboardings.key!!).workerName,
                onboardings = workerOnboardings.value.map { it.toOnboardingDto(workerId) },
            )
        }

    fun getHrOnboardings(workerId: UUID): List<OnboardingBlock> =
        onboardingRepository.getOnboardingsByWorkersId(
            workerService.getHrWorkersId(workerId),
        ).map { workerOnboardings ->
            OnboardingBlock(
                title = workerService.getWorkerById(workerOnboardings.key!!).workerName,
                onboardings = workerOnboardings.value.map { it.toOnboardingDto(workerId) },
            )
        }

    fun OnboardingDtoRaw.toOnboardingDto(workerId: UUID) =
        OnboardingDto(
            id = id,
            title = title,
            instructor = instructorId?.let { workerService.getWorkerById(instructorId) },
            recommender = recommender?.let { workerService.getRecommenderByType(recommender, workerId) },
            tags = onboardingRepository.getOnboardingTags(id),
            deadline = deadline,
        )
}
