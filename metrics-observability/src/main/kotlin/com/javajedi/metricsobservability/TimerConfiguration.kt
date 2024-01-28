package com.javajedi.metricsobservability

import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TimerConfiguration {

    @Bean
    fun timerRegistry(meterRegistry: MeterRegistry): TimedAspect {
        return TimedAspect(meterRegistry)
    }

}