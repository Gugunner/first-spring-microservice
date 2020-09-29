package com.gugunner.microservices;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.logging.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;

public class RequestContextLoggingFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(RequestContextLoggingFilter.class);

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String requestUUID = ((HttpServletRequest) request).getHeader(SBBLoggingConstants.REQUEST_UUID_HEADER);
            if(StringUtils.isEmpty(requestUUID)) {
                requestUUID = createId();
                log.info("Got request without {} and assign new {}", SBBLoggingConstants.REQUEST_UUID_HEADER, requestUUID);
            }
            MDC.put(SBBLoggingConstants.REQUEST_UUID_HEADER, requestUUID);
            chain.doFilter(request, response);
        }
        finally {
            MDC.clear();
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }

    public static String createId() {
        UUID uuid = java.util.UUID.randomUUID();
        return uuid.toString().replace("-","");
    }

    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
