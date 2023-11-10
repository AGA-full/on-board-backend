/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables.daos


import com.aga.onboard.tables.Team
import com.aga.onboard.tables.records.TeamRecord

import java.util.UUID

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.impl.DAOImpl


/**
 * Информация о командах в компании
 */
@Suppress("UNCHECKED_CAST")
open class TeamDao(configuration: Configuration?) : DAOImpl<TeamRecord, com.aga.onboard.tables.pojos.Team, UUID>(Team.TEAM, com.aga.onboard.tables.pojos.Team::class.java, configuration) {

    /**
     * Create a new TeamDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: com.aga.onboard.tables.pojos.Team): UUID? = o.id

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Team> = fetchRange(Team.TEAM.ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    fun fetchById(vararg values: UUID): List<com.aga.onboard.tables.pojos.Team> = fetch(Team.TEAM.ID, *values)

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    fun fetchOneById(value: UUID): com.aga.onboard.tables.pojos.Team? = fetchOne(Team.TEAM.ID, value)

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfName(lowerInclusive: String?, upperInclusive: String?): List<com.aga.onboard.tables.pojos.Team> = fetchRange(Team.TEAM.NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    fun fetchByName(vararg values: String): List<com.aga.onboard.tables.pojos.Team> = fetch(Team.TEAM.NAME, *values)

    /**
     * Fetch records that have <code>company_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfCompanyId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Team> = fetchRange(Team.TEAM.COMPANY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>company_id IN (values)</code>
     */
    fun fetchByCompanyId(vararg values: UUID): List<com.aga.onboard.tables.pojos.Team> = fetch(Team.TEAM.COMPANY_ID, *values)

    /**
     * Fetch records that have <code>parent_team_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfParentTeamId(lowerInclusive: UUID?, upperInclusive: UUID?): List<com.aga.onboard.tables.pojos.Team> = fetchRange(Team.TEAM.PARENT_TEAM_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>parent_team_id IN (values)</code>
     */
    fun fetchByParentTeamId(vararg values: UUID): List<com.aga.onboard.tables.pojos.Team> = fetch(Team.TEAM.PARENT_TEAM_ID, *values)
}