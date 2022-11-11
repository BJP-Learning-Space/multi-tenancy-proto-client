package com.practice.multitenancy.utils;

/**
 * 현재 요청한 사용자의 Tenant 정보를 저장하는 클래스
 */
public class TenantContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    private TenantContext() {
        throw new IllegalStateException("Utility class");
    }

    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}
