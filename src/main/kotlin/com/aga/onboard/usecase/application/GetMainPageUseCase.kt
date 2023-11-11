package com.aga.onboard.usecase.application

import com.aga.onboard.model.common.OnboardingBlock
import com.aga.onboard.model.common.WorkerRole
import com.aga.onboard.service.internal.OnboardingListService
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
    private val onboardingListService: OnboardingListService,
) : Usecase<MainPageRequest, MainPageResponse, Unit>() {
    override fun execute(request: MainPageRequest): UseCaseResult<MainPageResponse, Unit> =
        when (request.role) {
            WorkerRole.BASIC -> onboardingListService.getOnboardingList(
                request.workerId,
                OnboardingListService.OnboardingGroup.NOW,
                OnboardingListService.OnboardingGroup.RECOMMENDED,
                OnboardingListService.OnboardingGroup.NEW,
            )
            WorkerRole.INSTRUCTOR -> onboardingListService.getOnboardingList(
                request.workerId,
                OnboardingListService.OnboardingGroup.AUTHOR,
                OnboardingListService.OnboardingGroup.INSTRUCTOR,
            )
            WorkerRole.HEAD -> onboardingListService.getHeadOnboardings(request.workerId)
            WorkerRole.HR -> onboardingListService.getHrOnboardings(request.workerId)
        }.let { UseCaseResult.success(MainPageResponse(blocks = it)) }
}
