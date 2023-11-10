package com.aga.onboard.usecase.application

import com.aga.onboard.model.common.OnboardingBlock
import com.aga.onboard.model.common.WorkerRole
import com.aga.onboard.service.internal.OnboardingService
import com.aga.onboard.usecase.common.UseCaseResult
import com.aga.onboard.usecase.common.Usecase
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Component
import java.util.*

@Schema(description = "Запрос списков онбордингов на главной странице")
data class MainPageRequest(
    @Schema(description = "Идентификатор пользователя")
    val workerId: UUID,
    @Schema(description = "От лица какой роли смотрим страницу")
    val role: WorkerRole,
)

@Schema(description = "Cписки онбордингов на главной странице")
data class MainPageResponse(
    val blocks: List<OnboardingBlock>,
)

@Component
class GetMainPageUseCase(
    private val onboardingService: OnboardingService,
) : Usecase<MainPageRequest, MainPageResponse, Unit>() {
    override fun execute(request: MainPageRequest): UseCaseResult<MainPageResponse, Unit> =
        when (request.role) {
            WorkerRole.BASIC -> onboardingService.getOnboardingList(
                request.workerId,
                OnboardingService.OnboardingGroup.NOW,
                OnboardingService.OnboardingGroup.RECOMMENDED,
                OnboardingService.OnboardingGroup.NEW,
            )
            WorkerRole.INSTRUCTOR -> onboardingService.getOnboardingList(
                request.workerId,
                OnboardingService.OnboardingGroup.AUTHOR,
                OnboardingService.OnboardingGroup.INSTRUCTOR,
            )
            WorkerRole.HEAD -> onboardingService.getHeadOnboardings(request.workerId)
            WorkerRole.HR -> onboardingService.getHrOnboardings(request.workerId)
        }.let { UseCaseResult.success(MainPageResponse(blocks = it)) }
}
