package com.baggio

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate

@SpringBootApplication
class KafkaExampleApplication {

	@Bean
	fun commandLineRunner(
		kafkaTemplate: KafkaTemplate<String, Any>
	): CommandLineRunner = CommandLineRunner {
		for (i in 1..10) {
			kafkaTemplate.send("java-jedi", Message("Hello world"))
		}
	}

}

fun main(args: Array<String>) {
	runApplication<KafkaExampleApplication>(*args)
}