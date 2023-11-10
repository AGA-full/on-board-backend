/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables


import com.aga.onboard.Public
import com.aga.onboard.enums.DocRole
import com.aga.onboard.tables.records.OnboardingDocumentRecord

import java.util.UUID
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row3
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * Отношение сотрудников к документу онбординга
 */
@Suppress("UNCHECKED_CAST")
open class OnboardingDocument(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, OnboardingDocumentRecord>?,
    aliased: Table<OnboardingDocumentRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<OnboardingDocumentRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment("Отношение сотрудников к документу онбординга"),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.onboarding_document</code>
         */
        val ONBOARDING_DOCUMENT: OnboardingDocument = OnboardingDocument()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<OnboardingDocumentRecord> = OnboardingDocumentRecord::class.java

    /**
     * The column <code>public.onboarding_document.worker_id</code>.
     * Идентификатор сотрудника
     */
    val WORKER_ID: TableField<OnboardingDocumentRecord, UUID?> = createField(DSL.name("worker_id"), SQLDataType.UUID.nullable(false), this, "Идентификатор сотрудника")

    /**
     * The column <code>public.onboarding_document.onboarding_id</code>.
     */
    val ONBOARDING_ID: TableField<OnboardingDocumentRecord, UUID?> = createField(DSL.name("onboarding_id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.onboarding_document.role</code>. Роль сотрудника
     * в процессе работы над документом онбординга
     */
    val ROLE: TableField<OnboardingDocumentRecord, DocRole?> = createField(DSL.name("role"), SQLDataType.VARCHAR.asEnumDataType(com.aga.onboard.enums.DocRole::class.java), this, "Роль сотрудника в процессе работы над документом онбординга")

    private constructor(alias: Name, aliased: Table<OnboardingDocumentRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<OnboardingDocumentRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.onboarding_document</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.onboarding_document</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.onboarding_document</code> table reference
     */
    constructor(): this(DSL.name("onboarding_document"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, OnboardingDocumentRecord>): this(Internal.createPathAlias(child, key), child, key, ONBOARDING_DOCUMENT, null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun `as`(alias: String): OnboardingDocument = OnboardingDocument(DSL.name(alias), this)
    override fun `as`(alias: Name): OnboardingDocument = OnboardingDocument(alias, this)
    override fun `as`(alias: Table<*>): OnboardingDocument = OnboardingDocument(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): OnboardingDocument = OnboardingDocument(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): OnboardingDocument = OnboardingDocument(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): OnboardingDocument = OnboardingDocument(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row3<UUID?, UUID?, DocRole?> = super.fieldsRow() as Row3<UUID?, UUID?, DocRole?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (UUID?, UUID?, DocRole?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (UUID?, UUID?, DocRole?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}