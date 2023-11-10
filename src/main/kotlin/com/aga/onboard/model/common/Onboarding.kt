package com.aga.onboard.model.common

import com.aga.onboard.enums.Recommender
import java.time.LocalDateTime
import java.util.UUID

data class OnboardingBlock(
    val title: String,
    val onboardings: List<OnboardingDto>,
)

data class OnboardingDto(
    val id: UUID,
    val title: String,
    val tags: List<OnboardingTagDto>,
    val recommender: RecommenderDto? = null,
    val instructor: WorkerDto? = null,
    val deadline: LocalDateTime? = null,
)

data class RecommenderDto(
    val recommenderType: Recommender,
    val worker: WorkerDto?,
)
/*
data class InstructorDto(
    override val workerId: UUID?,
    override val workerName: String?,
) : WorkerDto(workerId, workerName)*/

data class OnboardingTagDto(
    val title: String,
    val color: String,
)
