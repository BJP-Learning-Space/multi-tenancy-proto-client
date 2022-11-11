//package com.practice.multitenancy.global.config;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.NoSuchFileException;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * DataSource 동적 생성을 위한 클래스
// */
//@Configuration
//public class DatasourceConfig2 {
//    public static final String TENANT_CODE_KEY = "dsdcode";
//
//    @Bean
//    public DataSource dataSource() throws NoSuchFileException {
//        final File[] tenantFiles = Paths.get("tenants").toFile().listFiles();
//        validateFiles(tenantFiles);
//
//        final Map<Object, Object> targetDataSources = new HashMap<>();
//
//        for (final File tenantFile : tenantFiles) {
//            final Properties properties = new Properties();
//
//            try (final FileInputStream fileInputStream = new FileInputStream(tenantFile)) {
//                properties.load(fileInputStream);
//
//                targetDataSources.put(properties.getProperty(TENANT_CODE_KEY), createDataSource(properties));
//            } catch (IOException e) {
//                throw new RuntimeException("Error in Create Tenant DataSource" + e);
//            }
//        }
//
//        final AbstractRoutingDataSource dataSource = new MultiTenantDataSource();
//
//        dataSource.setTargetDataSources(targetDataSources);
//        dataSource.setDefaultTargetDataSource(targetDataSources.get("default"));
//        dataSource.afterPropertiesSet();
//
//        return dataSource;
//    }
//
//    private void validateFiles(final File[] files) throws NoSuchFileException {
//        if (files == null || files.length == 0) {
//            throw new NoSuchFileException("No tenant files found");
//        }
//    }
//
//    private DataSource createDataSource(final Properties properties) {
//        final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//
//        dataSourceBuilder.driverClassName(properties.getProperty("datasource.driver-class-name"));
//        dataSourceBuilder.url(properties.getProperty("datasource.url"));
//        dataSourceBuilder.username(properties.getProperty("datasource.username"));
//        dataSourceBuilder.password(properties.getProperty("datasource.password"));
//
//        return dataSourceBuilder.build();
//    }
//}
