package com.aga.onboard.usecase.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class Usecase<Request, Response, Error> {
    abstract fun execute(request: Request): UseCaseResult<Response, Error>
}

class EmptySuccess()

class UseCaseResult<Response, Error> private constructor(
    val success: Response? = null,
    val error: Error? = null,
) {
    enum class Status {
        SUCCESS, ERROR,
    }

    companion object {
        fun <Response, Error> success(success: Response): UseCaseResult<Response, Error> =
            UseCaseResult(success = success)

        fun <Response, Error> error(error: Error): UseCaseResult<Response, Error> = UseCaseResult(error = error)

        fun <Error> successEmpty(): UseCaseResult<EmptySuccess, Error> = UseCaseResult(success = EmptySuccess())
    }

    val status: Status
        get() = when {
            success != null -> Status.SUCCESS
            error != null -> Status.ERROR
            else -> throw IllegalStateException("UsecaseResult without handles")
        }


    fun errorOrThrow(): Error = error ?: throw NoSuchElementException("Error is empty: result=$this")

    fun successOrThrow(): Response = success ?: throw NoSuchElementException("Success is empty: result=$this")

    fun toResponseEntity(): ResponseEntity<*> = fold(
        errorHandler = { ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(it) },
        successHandler = { ResponseEntity.ok(it) },
    )

    inline fun <reified T> fold(
        errorHandler: (Error) -> T = { throw IllegalStateException("There is not error result handler provided result=$it") },
        successHandler: (Response) -> T,
    ): T {
        return when {
            success != null -> successHandler(success)
            error != null -> errorHandler(error)
            else -> throw java.lang.IllegalStateException()
        }
    }
}
