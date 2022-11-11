package com.practice.multitenancy.global.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.datasource")
@ConstructorBinding
@RefreshScope
public class PropertyConfig {
    private final Map<String, DbAccessData> tenants;

    public PropertyConfig(final Map<String, DbAccessData> tenants) {
        this.tenants = tenants;
    }

    public Map<String, DbAccessData> getTenants() {
        return Collections.unmodifiableMap(tenants);
    }

    public Map<Object, Object> createDataSources() {
        final Map<Object, Object> targetDataSources = new HashMap<>();

        tenants.keySet()
                .forEach(key -> targetDataSources.put(key, tenants.get(key).createDataSource()));

        return targetDataSources;
    }

    static class DbAccessData {
        private final String url;
        private final String username;
        private final String password;
        private final String driverClassName;

        public DbAccessData(final String url, final String username, final String password, final String driverClassName) {
            this.url = url;
            this.username = username;
            this.password = password;
            this.driverClassName = driverClassName;
        }

        public DataSource createDataSource() {
            final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();

            dataSourceBuilder.url(url);
            dataSourceBuilder.username(username);
            dataSourceBuilder.password(password);
            dataSourceBuilder.driverClassName(driverClassName);

            return dataSourceBuilder.build();
        }
    }
}
