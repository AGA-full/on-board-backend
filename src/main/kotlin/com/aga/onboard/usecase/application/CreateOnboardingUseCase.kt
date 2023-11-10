package com.aga.onboard.usecase.application

import com.aga.onboard.enums.Recommender
import com.aga.onboard.model.common.OnboardingBlock
import com.aga.onboard.usecase.common.UseCaseResult
import com.aga.onboard.usecase.common.Usecase
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Component
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
    val onboardingId: Int? = null,
    @Schema(description = "Инструктор онбординга")
    val instructorId: UUID? = null,
    @Schema(description = "Дедлайн онбординга")
    val deadline: UUID? = null,
)

@Component
class CreateOnboardingUseCase(): Usecase<CreateOnboardingRequest, Void, Void>() {
    override fun execute(request: CreateOnboardingRequest): UseCaseResult<Void, Void> {
        TODO("Not yet implemented")
    }

}
