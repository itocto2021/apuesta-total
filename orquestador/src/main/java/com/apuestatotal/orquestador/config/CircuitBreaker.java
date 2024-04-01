package com.apuestatotal.orquestador.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

@Configuration
public class CircuitBreaker {
    @Bean(name = "circuitbreaker")
    public CircuitBreakerRegistry circuitbreaker() {
        return CircuitBreakerRegistry.of(Map.of("apuestatotal-api",
                CircuitBreakerConfig.custom().slidingWindowSize(10).slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                        .waitDurationInOpenState(Duration.ofSeconds(5)).minimumNumberOfCalls(5)
                        .failureRateThreshold(50.0f).build()));
    }

    @Bean(name = "retry")
    RetryRegistry retry() {
        return RetryRegistry.of(Map.of("apuestatotal-api", RetryConfig.custom().maxAttempts(3)
                .waitDuration(Duration.of(3, ChronoUnit.SECONDS)).retryExceptions().build()));
    }
}
