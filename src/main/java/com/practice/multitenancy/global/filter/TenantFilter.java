package com.practice.multitenancy.global.filter;

import com.practice.multitenancy.utils.TenantContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * 요청에 대한 Tenant 정보를 추출하여 TenantContext에 저장하는 필터
 */
@Component
@Order(1)
public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String dsdcode = request.getHeader("dsdcode");

        if (Objects.nonNull(dsdcode)) {
            TenantContext.setCurrentTenant(dsdcode);
        }

        try {
            chain.doFilter(servletRequest, response);
        } finally {
            TenantContext.clear();
        }
    }
}
