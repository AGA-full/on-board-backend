/*
 * This file is generated by jOOQ.
 */
package com.aga.onboard.tables.pojos


import java.io.Serializable
import java.util.UUID


/**
 * Информация о командах в компании
 */
@Suppress("UNCHECKED_CAST")
data class Team(
    var id: UUID? = null,
    var name: String? = null,
    var companyId: UUID? = null,
    var parentTeamId: UUID? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Team = other as Team
        if (this.id == null) {
            if (o.id != null)
                return false
        }
        else if (this.id != o.id)
            return false
        if (this.name == null) {
            if (o.name != null)
                return false
        }
        else if (this.name != o.name)
            return false
        if (this.companyId == null) {
            if (o.companyId != null)
                return false
        }
        else if (this.companyId != o.companyId)
            return false
        if (this.parentTeamId == null) {
            if (o.parentTeamId != null)
                return false
        }
        else if (this.parentTeamId != o.parentTeamId)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.id == null) 0 else this.id.hashCode())
        result = prime * result + (if (this.name == null) 0 else this.name.hashCode())
        result = prime * result + (if (this.companyId == null) 0 else this.companyId.hashCode())
        result = prime * result + (if (this.parentTeamId == null) 0 else this.parentTeamId.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Team (")

        sb.append(id)
        sb.append(", ").append(name)
        sb.append(", ").append(companyId)
        sb.append(", ").append(parentTeamId)

        sb.append(")")
        return sb.toString()
    }
}
