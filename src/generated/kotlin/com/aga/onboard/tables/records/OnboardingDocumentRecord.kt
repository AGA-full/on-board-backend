/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables.records


import com.aga.onboard.enums.DocRole
import com.aga.onboard.tables.OnboardingDocument

import java.util.UUID

import org.jooq.Field
import org.jooq.Record3
import org.jooq.Row3
import org.jooq.impl.TableRecordImpl


/**
 * Отношение сотрудников к документу онбординга
 */
@Suppress("UNCHECKED_CAST")
open class OnboardingDocumentRecord() : TableRecordImpl<OnboardingDocumentRecord>(OnboardingDocument.ONBOARDING_DOCUMENT), Record3<UUID?, UUID?, DocRole?> {

    open var workerId: UUID?
        set(value): Unit = set(0, value)
        get(): UUID? = get(0) as UUID?

    open var onboardingId: UUID?
        set(value): Unit = set(1, value)
        get(): UUID? = get(1) as UUID?

    open var role: DocRole?
        set(value): Unit = set(2, value)
        get(): DocRole? = get(2) as DocRole?

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row3<UUID?, UUID?, DocRole?> = super.fieldsRow() as Row3<UUID?, UUID?, DocRole?>
    override fun valuesRow(): Row3<UUID?, UUID?, DocRole?> = super.valuesRow() as Row3<UUID?, UUID?, DocRole?>
    override fun field1(): Field<UUID?> = OnboardingDocument.ONBOARDING_DOCUMENT.WORKER_ID
    override fun field2(): Field<UUID?> = OnboardingDocument.ONBOARDING_DOCUMENT.ONBOARDING_ID
    override fun field3(): Field<DocRole?> = OnboardingDocument.ONBOARDING_DOCUMENT.ROLE
    override fun component1(): UUID? = workerId
    override fun component2(): UUID? = onboardingId
    override fun component3(): DocRole? = role
    override fun value1(): UUID? = workerId
    override fun value2(): UUID? = onboardingId
    override fun value3(): DocRole? = role

    override fun value1(value: UUID?): OnboardingDocumentRecord {
        set(0, value)
        return this
    }

    override fun value2(value: UUID?): OnboardingDocumentRecord {
        set(1, value)
        return this
    }

    override fun value3(value: DocRole?): OnboardingDocumentRecord {
        set(2, value)
        return this
    }

    override fun values(value1: UUID?, value2: UUID?, value3: DocRole?): OnboardingDocumentRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        return this
    }

    /**
     * Create a detached, initialised OnboardingDocumentRecord
     */
    constructor(workerId: UUID? = null, onboardingId: UUID? = null, role: DocRole? = null): this() {
        this.workerId = workerId
        this.onboardingId = onboardingId
        this.role = role
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised OnboardingDocumentRecord
     */
    constructor(value: com.aga.onboard.tables.pojos.OnboardingDocument?): this() {
        if (value != null) {
            this.workerId = value.workerId
            this.onboardingId = value.onboardingId
            this.role = value.role
            resetChangedOnNotNull()
        }
    }
}