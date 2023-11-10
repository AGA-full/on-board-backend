package com.aga.onboard.model.internal

import com.aga.onboard.enums.Recommender
import java.time.LocalDateTime
import java.util.*

data class OnboardingDtoRaw(
    val id: UUID,
    val workerId: UUID? = null,
    val title: String,
    val recommender: Recommender? = null,
    val instructorId: UUID? = null,
    val deadline: LocalDateTime? = null,
)

data class OnboardingBlockRaw(
    val title: String,
    val onboardings: List<OnboardingDtoRaw>,
)