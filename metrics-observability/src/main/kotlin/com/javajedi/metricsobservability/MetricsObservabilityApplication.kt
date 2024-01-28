package com.javajedi.metricsobservability

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MetricsObservabilityApplication

fun main(args: Array<String>) {
	runApplication<MetricsObservabilityApplication>(*args)
}
