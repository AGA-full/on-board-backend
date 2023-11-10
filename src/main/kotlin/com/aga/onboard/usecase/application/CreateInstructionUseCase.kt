package com.aga.onboard.usecase.application

import com.aga.onboard.model.external.notion.*
import com.aga.onboard.repository.OnboardingRepository
import com.aga.onboard.service.external.NotionService
import com.aga.onboard.usecase.common.UseCaseResult
import com.aga.onboard.usecase.common.Usecase
import org.springframework.stereotype.Component
import java.util.*

data class CreateInstructionRequest(
    val companyId: UUID,
    val title: String,
    val tags: List<Int>,
)

data class CreateInstructionResponse(
    val onboardingId: UUID,
)

@Component
class CreateInstructionUseCase(
    private val onboardingRepository: OnboardingRepository,
    private val notionService: NotionService,
) : Usecase<CreateInstructionRequest, CreateInstructionResponse, Unit>() {
    override fun execute(request: CreateInstructionRequest): UseCaseResult<CreateInstructionResponse, Unit> =
        notionService.createPage(
            request = CreatePageRequest(
                parent = NotionParent(pageId = "80ffc949223e4d1eaa1357d94d233315"),
                properties = NotionProperties(
                    listOf(
                        NotionText(
                            text = NotionTextProperties(
                                content = request.title,
                            ),
                        ),
                    ),
                ),
            ),
        )
            .let { createPageNotionRequest ->
                onboardingRepository.createOnboarding(
                    companyId = request.companyId,
                    title = request.title,
                    notionPageId = createPageNotionRequest.id,
                ).also {
                    onboardingRepository.addOnboardingTags(it, tags = request.tags)
                }.let {
                    UseCaseResult.success(CreateInstructionResponse(it))
                }
            }
}
