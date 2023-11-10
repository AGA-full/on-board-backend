package com.aga.onboard.model.common

import java.util.UUID

class OnboardingRepositoryError(
    private val onboardingId: UUID? = null,
    private val action: OnboardingRepositoryAction,
) : Exception("Can't $action $onboardingId")

enum class OnboardingRepositoryAction {
    CREATE,
}
