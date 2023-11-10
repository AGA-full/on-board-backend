package com.aga.onboard.model.external.notion

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(value = SnakeCaseStrategy::class)
data class CreatePageRequest(
    val parent: NotionParent,
    val properties: NotionProperties,
)

@JsonNaming(value = SnakeCaseStrategy::class)
data class NotionParent(
    val pageId: String,
)

@JsonNaming(value = SnakeCaseStrategy::class)
data class NotionProperties(
    val title: List<NotionBlock>,
)

open class NotionBlock

@JsonNaming(value = SnakeCaseStrategy::class)
data class NotionText(
    val text: NotionTextProperties,
) : NotionBlock()

@JsonNaming(value = SnakeCaseStrategy::class)
data class NotionTextProperties(
    val content: String,
)

@JsonNaming(value = SnakeCaseStrategy::class)
data class CreatePageResponse(
    val id: String,
)
