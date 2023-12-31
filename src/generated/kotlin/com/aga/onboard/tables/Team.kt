/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables


import com.aga.onboard.Public
import com.aga.onboard.keys.TEAM_PKEY
import com.aga.onboard.tables.records.TeamRecord

import java.util.UUID
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row4
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
 * Информация о командах в компании
 */
@Suppress("UNCHECKED_CAST")
open class Team(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, TeamRecord>?,
    aliased: Table<TeamRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<TeamRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment("Информация о командах в компании"),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.team</code>
         */
        val TEAM: Team = Team()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TeamRecord> = TeamRecord::class.java

    /**
     * The column <code>public.team.id</code>. Идентификатор команды
     */
    val ID: TableField<TeamRecord, UUID?> = createField(DSL.name("id"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("uuid_generate_v4()"), SQLDataType.UUID)), this, "Идентификатор команды")

    /**
     * The column <code>public.team.name</code>. Название команды
     */
    val NAME: TableField<TeamRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(30).nullable(false), this, "Название команды")

    /**
     * The column <code>public.team.company_id</code>. Идентификатор компании
     */
    val COMPANY_ID: TableField<TeamRecord, UUID?> = createField(DSL.name("company_id"), SQLDataType.UUID.nullable(false), this, "Идентификатор компании")

    /**
     * The column <code>public.team.parent_team_id</code>. Идентификатор
     * родительской команды
     */
    val PARENT_TEAM_ID: TableField<TeamRecord, UUID?> = createField(DSL.name("parent_team_id"), SQLDataType.UUID, this, "Идентификатор родительской команды")

    private constructor(alias: Name, aliased: Table<TeamRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<TeamRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.team</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.team</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.team</code> table reference
     */
    constructor(): this(DSL.name("team"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, TeamRecord>): this(Internal.createPathAlias(child, key), child, key, TEAM, null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<TeamRecord> = TEAM_PKEY
    override fun `as`(alias: String): Team = Team(DSL.name(alias), this)
    override fun `as`(alias: Name): Team = Team(alias, this)
    override fun `as`(alias: Table<*>): Team = Team(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Team = Team(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Team = Team(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Team = Team(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<UUID?, String?, UUID?, UUID?> = super.fieldsRow() as Row4<UUID?, String?, UUID?, UUID?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (UUID?, String?, UUID?, UUID?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (UUID?, String?, UUID?, UUID?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
