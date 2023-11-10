package com.aga.onboard.rest

import com.aga.onboard.usecase.application.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Application", description = "ручки для веб-приложения")
@RequestMapping("/application")
class ApplicationController(
    val getMainPageUseCase: GetMainPageUseCase,
    val createInstructionUseCase: CreateInstructionUseCase,
    val createOnboardingUseCase: CreateOnboardingUseCase
) {
    @Operation(summary = "Получение списка онбордингов")
    @PostMapping("/mainPage")
    fun mainPage(@RequestBody request: MainPageRequest): ResponseEntity<*> =
        getMainPageUseCase.execute(request).toResponseEntity()

    @Operation(summary = "Создание инструкции")
    @PostMapping("/instruction/create")
    fun createInstruction(@RequestBody request: CreateInstructionRequest): ResponseEntity<*> =
        createInstructionUseCase.execute(request).toResponseEntity()

    @Operation(summary = "Создание онбординга")
    @PostMapping("/onboarding/create")
    fun createOnboarding(@RequestBody request: CreateOnboardingRequest): ResponseEntity<*> =
        createOnboardingUseCase.execute(request).toResponseEntity()
}
