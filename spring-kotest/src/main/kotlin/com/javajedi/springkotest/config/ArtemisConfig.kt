package com.javajedi.springkotest.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import jakarta.jms.ConnectionFactory
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType


@Configuration
class ArtemisConfig {

    @Bean
    fun defaultFactory(
            connectionFactory: ConnectionFactory?,
            configurer: DefaultJmsListenerContainerFactoryConfigurer
    ): JmsListenerContainerFactory<*> {
        val factory = DefaultJmsListenerContainerFactory()
        configurer.configure(factory, connectionFactory)
        return factory
    }

    @Bean
    fun jacksonJmsMessageConverter(objectMapper: ObjectMapper): MessageConverter {
        val converter = MappingJackson2MessageConverter()
        converter.setTargetType(MessageType.TEXT)
        converter.setObjectMapper(objectMapper.registerModule(KotlinModule.Builder().build()))
        converter.setTypeIdPropertyName("_type")
        return converter
    }

}