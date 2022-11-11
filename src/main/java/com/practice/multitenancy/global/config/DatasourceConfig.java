package com.practice.multitenancy.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * DataSource 동적 생성을 위한 클래스
 */
@Configuration
public class DatasourceConfig {
    private final PropertyConfig propertyConfig;

    public DatasourceConfig(final PropertyConfig propertyConfig) {
        this.propertyConfig = propertyConfig;
    }

    @Bean
    public DataSource dataSource() {
        final Map<Object, Object> targetDataSources = propertyConfig.createDataSources();
        final AbstractRoutingDataSource dataSource = new MultiTenantDataSource();

        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(targetDataSources.get("default"));
        dataSource.afterPropertiesSet();

        return dataSource;
    }
}
