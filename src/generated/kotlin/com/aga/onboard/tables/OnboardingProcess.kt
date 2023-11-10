/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables


import com.aga.onboard.Public
import com.aga.onboard.enums.Recommender
import com.aga.onboard.keys.PK_ONBOARDING_PROCESS
import com.aga.onboard.tables.records.OnboardingProcessRecord

import java.time.LocalDateTime
import java.util.UUID
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row6
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * Отношение сотрудников к процессу онбординга
 */
@Suppress("UNCHECKED_CAST")
open class OnboardingProcess(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, OnboardingProcessRecord>?,
    aliased: Table<OnboardingProcessRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<OnboardingProcessRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment("Отношение сотрудников к процессу онбординга"),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.onboarding_process</code>
         */
        val ONBOARDING_PROCESS: OnboardingProcess = OnboardingProcess()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<OnboardingProcessRecord> = OnboardingProcessRecord::class.java

    /**
     * The column <code>public.onboarding_process.worker_id</code>.
     * Идентификатор сотрудника, которому назначен онбординг
     */
    val WORKER_ID: TableField<OnboardingProcessRecord, UUID?> = createField(DSL.name("worker_id"), SQLDataType.UUID.nullable(false), this, "Идентификатор сотрудника, которому назначен онбординг")

    /**
     * The column <code>public.onboarding_process.onboarding_id</code>.
     * Идентификатор инструкции
     */
    val ONBOARDING_ID: TableField<OnboardingProcessRecord, UUID?> = createField(DSL.name("onboarding_id"), SQLDataType.UUID.nullable(false), this, "Идентификатор инструкции")

    /**
     * The column <code>public.onboarding_process.recommender</code>. Принцип
     * рекомендации, по которому проводится обординг
     */
    val RECOMMENDER: TableField<OnboardingProcessRecord, Recommender?> = createField(DSL.name("recommender"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(com.aga.onboard.enums.Recommender::class.java), this, "Принцип рекомендации, по которому проводится обординг")

    /**
     * The column <code>public.onboarding_process.instructor_id</code>.
     * Инструктор в процессе онбординга
     */
    val INSTRUCTOR_ID: TableField<OnboardingProcessRecord, UUID?> = createField(DSL.name("instructor_id"), SQLDataType.UUID, this, "Инструктор в процессе онбординга")

    /**
     * The column <code>public.onboarding_process.progress</code>. На каком
     * этапе сейчас онбординг
     */
    val PROGRESS: TableField<OnboardingProcessRecord, String?> = createField(DSL.name("progress"), SQLDataType.VARCHAR(256), this, "На каком этапе сейчас онбординг")

    /**
     * The column <code>public.onboarding_process.deadline</code>. Дата дедлайна
     * по онбордингу
     */
    val DEADLINE: TableField<OnboardingProcessRecord, LocalDateTime?> = createField(DSL.name("deadline"), SQLDataType.LOCALDATETIME(6), this, "Дата дедлайна по онбордингу")

    private constructor(alias: Name, aliased: Table<OnboardingProcessRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<OnboardingProcessRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.onboarding_process</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.onboarding_process</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.onboarding_process</code> table reference
     */
    constructor(): this(DSL.name("onboarding_process"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, OnboardingProcessRecord>): this(Internal.createPathAlias(child, key), child, key, ONBOARDING_PROCESS, null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<OnboardingProcessRecord> = PK_ONBOARDING_PROCESS
    override fun `as`(alias: String): OnboardingProcess = OnboardingProcess(DSL.name(alias), this)
    override fun `as`(alias: Name): OnboardingProcess = OnboardingProcess(alias, this)
    override fun `as`(alias: Table<*>): OnboardingProcess = OnboardingProcess(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): OnboardingProcess = OnboardingProcess(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): OnboardingProcess = OnboardingProcess(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): OnboardingProcess = OnboardingProcess(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row6<UUID?, UUID?, Recommender?, UUID?, String?, LocalDateTime?> = super.fieldsRow() as Row6<UUID?, UUID?, Recommender?, UUID?, String?, LocalDateTime?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (UUID?, UUID?, Recommender?, UUID?, String?, LocalDateTime?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (UUID?, UUID?, Recommender?, UUID?, String?, LocalDateTime?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}