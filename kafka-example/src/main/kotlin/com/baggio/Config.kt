package com.baggio

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfiguration {

    @Bean
    fun javajediTopic(): NewTopic {
        return TopicBuilder.name("javajedi").build()
    }

}