package ru.finnetrolle.smrl.config

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * This class is developed by maxsyachin on 29.07.16
 * for smlr
 * under MIT license
 */
@Configuration
open class JacksonConfig {
    @Bean open fun kotlinModule() = KotlinModule()
}