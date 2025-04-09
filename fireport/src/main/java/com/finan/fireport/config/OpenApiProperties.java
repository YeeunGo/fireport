package com.finan.fireport.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "open-api.base-url")
@Getter
public class OpenApiProperties {
    private String http;
    private String https;
}
