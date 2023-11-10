package com.aga.onboard.repository

import com.aga.onboard.enums.DocRole
import com.aga.onboard.model.common.OnboardingRepositoryAction
import com.aga.onboard.model.common.OnboardingRepositoryError
import com.aga.onboard.model.common.OnboardingTagDto
import com.aga.onboard.model.internal.OnboardingDtoRaw
import com.aga.onboard.tables.daos.OnboardingDao
import com.aga.onboard.tables.records.OnboardingTagRecord
import com.aga.onboard.tables.references.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.jooq.Configuration
import org.springframework.stereotype.Repository
import java.util.*

const val MAIN_TAG_RANK = 1

@Repository
class OnboardingRepository(
    configuration: Configuration,
    val objectMapper: ObjectMapper,
) : OnboardingDao(configuration) {
    fun createOnboarding(title: String, notionPageId: String, companyId: UUID): UUID =
        ctx().insertInto(ONBOARDING)
            .columns(ONBOARDING.TITLE, ONBOARDING.NOTION_PAGE_ID, ONBOARDING.COMPANY_ID)
            .values(title, notionPageId, companyId)
            .returningResult(ONBOARDING.ID)
            .fetchOne()
            ?.getValue(ONBOARDING.ID) ?: throw OnboardingRepositoryError(action = OnboardingRepositoryAction.CREATE)

    fun addOnboardingTags(onboardingId: UUID, tags: List<Int>) =
        ctx().insertInto(
            ONBOARDING_TAG,
            ONBOARDING_TAG.TAG_ID,
            ONBOARDING_TAG.ONBOARDING_ID,
            ONBOARDING_TAG.TAG_RANK,
        )
            .valuesOfRecords(
                tags.mapIndexed { idx, tagId ->
                    OnboardingTagRecord(tagId, onboardingId, idx)
                },
            )
            .execute()

    fun getCurrentOnboardings(workerId: UUID): MutableList<OnboardingDtoRaw> =
        ctx().select(
            ONBOARDING.ID,
            ONBOARDING.TITLE,
            ONBOARDING_PROCESS.RECOMMENDER,
            ONBOARDING_PROCESS.INSTRUCTOR_ID,
            ONBOARDING_PROCESS.DEADLINE,
        )
            .from(
                ONBOARDING_PROCESS
                    .join(ONBOARDING)
                    .on(
                        ONBOARDING_PROCESS.ONBOARDING_ID
                            .eq(ONBOARDING.ID),
                    ),
            )
            .where(
                ONBOARDING_PROCESS.WORKER_ID.eq(workerId),
                ONBOARDING_PROCESS.PROGRESS.isNotNull,
            )
            .fetchInto(OnboardingDtoRaw::class.java)

    fun getRecommendedOnboardings(workerId: UUID): MutableList<OnboardingDtoRaw> =
        ctx().select(
            ONBOARDING.ID,
            ONBOARDING.TITLE,
            ONBOARDING_PROCESS.RECOMMENDER,
            ONBOARDING_PROCESS.INSTRUCTOR_ID,
            ONBOARDING_PROCESS.DEADLINE,
        )
            .from(
                ONBOARDING_PROCESS
                    .join(ONBOARDING)
                    .on(
                        ONBOARDING_PROCESS.ONBOARDING_ID
                            .eq(ONBOARDING.ID),
                    ),
            )
            .where(
                ONBOARDING_PROCESS.WORKER_ID.eq(workerId),
                ONBOARDING_PROCESS.PROGRESS.isNull,
            )
            .fetchInto(OnboardingDtoRaw::class.java)

    fun getOnboardingTags(id: UUID): List<OnboardingTagDto> =
        ctx().select(TAG.TITLE, TAG.COLOR)
            .from(TAG)
            .where(
                TAG.ID.`in`(
                    ctx().select(ONBOARDING_TAG.TAG_ID)
                        .from(ONBOARDING_TAG)
                        .where(ONBOARDING_TAG.ONBOARDING_ID.eq(id)),
                ),
            )
            .fetchInto(OnboardingTagDto::class.java)

    fun getAuthoredOnboardings(workerId: UUID): List<OnboardingDtoRaw> =
        ctx().select(
            ONBOARDING.ID,
            ONBOARDING.TITLE,
        )
            .from(
                ONBOARDING
                    .join(ONBOARDING_DOCUMENT)
                    .on(
                        ONBOARDING_DOCUMENT.ONBOARDING_ID
                            .eq(ONBOARDING.ID),
                    ),
            )
            .where(
                ONBOARDING_DOCUMENT.WORKER_ID.eq(workerId),
                ONBOARDING_DOCUMENT.ROLE.eq(DocRole.AUTHOR),
            )
            .fetchInto(OnboardingDtoRaw::class.java)

    fun getInstructorOnboardings(workerId: UUID): List<OnboardingDtoRaw> =
        ctx().select(
            ONBOARDING.ID,
            ONBOARDING.TITLE,
        )
            .from(
                ONBOARDING
                    .join(ONBOARDING_DOCUMENT)
                    .on(
                        ONBOARDING_DOCUMENT.ONBOARDING_ID
                            .eq(ONBOARDING.ID),
                    ),
            )
            .where(
                ONBOARDING_DOCUMENT.WORKER_ID.eq(workerId),
                ONBOARDING_DOCUMENT.ROLE.eq(DocRole.INSTRUCTOR),
            )
            .fetchInto(OnboardingDtoRaw::class.java)

    fun getOnboardingsByWorkersId(workerIds: List<UUID>): Map<UUID, List<OnboardingDtoRaw>> =
        ctx().select(
            ONBOARDING_PROCESS.WORKER_ID,
            ONBOARDING.ID,
            ONBOARDING.TITLE,
            ONBOARDING_PROCESS.INSTRUCTOR_ID,
            ONBOARDING_PROCESS.DEADLINE,
        )
            .from(
                WORKER.leftJoin(
                    ONBOARDING_PROCESS
                        .join(ONBOARDING)
                        .on(
                            ONBOARDING_PROCESS.ONBOARDING_ID
                                .eq(ONBOARDING.ID),
                        ),
                ).on(WORKER.ID.eq(ONBOARDING_PROCESS.WORKER_ID)),
            )
            .where(
                ONBOARDING_PROCESS.WORKER_ID.`in`(workerIds),
            )
            .fetchInto(OnboardingDtoRaw::class.java)
            .groupBy { it.workerId!! }
}
