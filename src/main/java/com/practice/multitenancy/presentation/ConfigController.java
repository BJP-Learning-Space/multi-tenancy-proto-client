package com.practice.multitenancy.presentation;

import com.practice.multitenancy.global.config.PropertyConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    private final PropertyConfig propertyConfig;

    public ConfigController(final PropertyConfig propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    @GetMapping("/config")
    public ResponseEntity<String> config() {
        return ResponseEntity.ok(propertyConfig.toString());
    }
}
