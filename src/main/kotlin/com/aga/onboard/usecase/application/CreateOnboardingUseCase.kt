package com.aga.onboard.usecase.application

import com.aga.onboard.enums.Recommender
import com.aga.onboard.repository.OnboardingRepository
import com.aga.onboard.usecase.common.EmptySuccess
import com.aga.onboard.usecase.common.UseCaseResult
import com.aga.onboard.usecase.common.Usecase
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Schema(description = "Запрос на создание процесса онбординга")
data class CreateOnboardingRequest(
    @Schema(description = "Идентификатор пользователя")
    val workerId: UUID,
    @Schema(description = "От кого назначен онбординг")
    val recommendationType: Recommender,
    @Schema(description = "Тэг, по которому собираются инструкции")
    val tagId: Int? = null,
    @Schema(description = "Онбординг, по которому назначется инструктаж")
    val onboardingId: UUID? = null,
    @Schema(description = "Инструктор онбординга")
    val instructorId: UUID? = null,
    @Schema(description = "Дедлайн онбординга")
    val deadline: LocalDateTime? = null,
)

@Schema(description = "Ошибка запроса на создание процесса онбординга")
data class CreateOnboardingError(
    val code: Code,
) {
    enum class Code {
        TAG_ID_AND_ONBOARDING_ID_NULL,
    }
}

@Component
class CreateOnboardingUseCase(
    val onboardingRepository: OnboardingRepository,
) : Usecase<CreateOnboardingRequest, EmptySuccess, CreateOnboardingError>() {
    override fun execute(request: CreateOnboardingRequest): UseCaseResult<EmptySuccess, CreateOnboardingError> =
        request.tagId?.let {
            onboardingRepository.getOnboardingsByTag(request.tagId)
                .map {
                    onboardingRepository.createOnboardingProcess(
                        workerId = request.workerId,
                        recommendationType = request.recommendationType,
                        onboardingId = it,
                        instructorId = request.instructorId,
                        deadline = request.deadline,
                    )
                }
            UseCaseResult.successEmpty()
        } ?: request.onboardingId?.let {
            onboardingRepository.createOnboardingProcess(
                workerId = request.workerId,
                recommendationType = request.recommendationType,
                onboardingId = it,
                instructorId = request.instructorId,
                deadline = request.deadline,
            )
            UseCaseResult.successEmpty()
        } ?: UseCaseResult.error(
            CreateOnboardingError(
                CreateOnboardingError.Code.TAG_ID_AND_ONBOARDING_ID_NULL,
            ),
        )
}
