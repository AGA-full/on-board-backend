package com.aga.onboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class OnBoardApplication

fun main(args: Array<String>) {
    runApplication<OnBoardApplication>(*args)
}
