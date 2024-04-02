package com.javajedi.jps;

import com.javajedi.jps.todo.TodoJpsClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(JsonPlaceHolderServiceProperties.class)
public class JsonPlaceholderServiceConfiguration {

    private final JsonPlaceHolderServiceProperties jpsProperties;

    public JsonPlaceholderServiceConfiguration(JsonPlaceHolderServiceProperties jpsProperties) {
        this.jpsProperties = jpsProperties;
    }

    @Bean
    RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl(jpsProperties.baseUrl())
                .build();
    }

    @Bean
    TodoJpsClient todoJpsClient(RestClient restClient) {
        return new TodoJpsClient(restClient);
    }

}
