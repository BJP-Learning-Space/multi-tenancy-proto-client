package com.practice.multitenancy.global.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {PropertyConfig.class})
public class ConfigContainer {
}
