package com.eazybytes;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class EazyBankBackendApplication {

    @Bean
    public InitializingBean initializingSecurityContextMode() {
        // MODE_THREADLOCAL is the default value. Each thread (per-request) has its own auth details in the SecurityContext
        return () -> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_THREADLOCAL);
    }

    public static void main(String[] args) {
        SpringApplication.run(EazyBankBackendApplication.class, args);
    }

}
