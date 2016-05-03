package ru.finnetrolle.smrl

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SmlrApplication

fun main(args: Array<String>) {
    SpringApplication.run(SmlrApplication::class.java, *args)
}
