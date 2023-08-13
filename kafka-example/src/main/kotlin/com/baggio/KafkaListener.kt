package com.baggio

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaListener {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(KafkaListener::class.java)
    }

    @KafkaListener(topics = ["javajedi"], groupId = "notification-group")
    fun listener(data: Message) {
        log.info("Message consumed: $data\uD83C\uDF89")
    }

}