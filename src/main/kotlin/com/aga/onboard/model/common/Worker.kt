package com.aga.onboard.model.common

import java.util.*

enum class WorkerRole {
    BASIC, INSTRUCTOR, HEAD, HR
}

data class WorkerDto(
    val workerId: UUID,
    val workerName: String,
)
