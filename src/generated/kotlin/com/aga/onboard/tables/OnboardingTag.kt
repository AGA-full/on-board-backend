/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables


import com.aga.onboard.Public
import com.aga.onboard.keys.PK_ONBOARDING_TAG
import com.aga.onboard.tables.records.OnboardingTagRecord

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
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class OnboardingTag(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, OnboardingTagRecord>?,
    aliased: Table<OnboardingTagRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<OnboardingTagRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.onboarding_tag</code>
         */
        val ONBOARDING_TAG: OnboardingTag = OnboardingTag()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<OnboardingTagRecord> = OnboardingTagRecord::class.java

    /**
     * The column <code>public.onboarding_tag.tag_id</code>. Идентификатор тэга
     */
    val TAG_ID: TableField<OnboardingTagRecord, Int?> = createField(DSL.name("tag_id"), SQLDataType.INTEGER.nullable(false), this, "Идентификатор тэга")

    /**
     * The column <code>public.onboarding_tag.onboarding_id</code>.
     * Идентификатор онбординга
     */
    val ONBOARDING_ID: TableField<OnboardingTagRecord, UUID?> = createField(DSL.name("onboarding_id"), SQLDataType.UUID.nullable(false), this, "Идентификатор онбординга")

    /**
     * The column <code>public.onboarding_tag.tag_rank</code>. Ранг тэга
     */
    val TAG_RANK: TableField<OnboardingTagRecord, Int?> = createField(DSL.name("tag_rank"), SQLDataType.INTEGER, this, "Ранг тэга")

    private constructor(alias: Name, aliased: Table<OnboardingTagRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<OnboardingTagRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.onboarding_tag</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.onboarding_tag</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.onboarding_tag</code> table reference
     */
    constructor(): this(DSL.name("onboarding_tag"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, OnboardingTagRecord>): this(Internal.createPathAlias(child, key), child, key, ONBOARDING_TAG, null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<OnboardingTagRecord> = PK_ONBOARDING_TAG
    override fun `as`(alias: String): OnboardingTag = OnboardingTag(DSL.name(alias), this)
    override fun `as`(alias: Name): OnboardingTag = OnboardingTag(alias, this)
    override fun `as`(alias: Table<*>): OnboardingTag = OnboardingTag(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): OnboardingTag = OnboardingTag(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): OnboardingTag = OnboardingTag(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): OnboardingTag = OnboardingTag(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row3<Int?, UUID?, Int?> = super.fieldsRow() as Row3<Int?, UUID?, Int?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, UUID?, Int?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, UUID?, Int?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
