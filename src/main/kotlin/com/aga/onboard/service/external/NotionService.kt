package com.aga.onboard.service.external

import com.aga.onboard.model.external.notion.CreatePageRequest
import com.aga.onboard.model.external.notion.CreatePageResponse
import feign.HeaderMap
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

/*@Headers(
    "Authorization: Bearer secret_aSUD5kSTiA3ZDnoA9T1W1034OB5TsX4qWSxwXahFo9G",
)*/
@FeignClient(
    name = "notion",
    url = "https://api.notion.com",
)
interface NotionService {
    companion object {
        val HEADER_MAP = mapOf(
            "Authorization" to "Bearer secret_aSUD5kSTiA3ZDnoA9T1W1034OB5TsX4qWSxwXahFo9G",
            "Content-Type" to "application/json",
            "Notion-Version" to "2022-06-28",
        )
    }

    @PostMapping("/v1/pages")
    fun createPage(
        @RequestHeader headers: Map<String, String> = HEADER_MAP,
        @RequestBody request: CreatePageRequest,
    ): CreatePageResponse
}
