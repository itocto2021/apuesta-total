package com.apuestatotal.orquestador.services;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import io.github.resilience4j.reactor.retry.RetryOperator;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class GenericRestClientImpl {
    private final WebClient webClient;
    private final CircuitBreakerRegistry circuitbreaker;
    private final RetryRegistry retry;

    public GenericRestClientImpl(WebClient webClient, CircuitBreakerRegistry circuitbreaker, RetryRegistry retry) {
        this.webClient = webClient;
        this.circuitbreaker = circuitbreaker;
        this.retry = retry;
    }

    @SuppressWarnings("null")
    public <T> Mono<T> getCallEndpoint(HttpMethod method, String uri, Class<T> responseType) {

        // Crear un CircuitBreaker
        var circuitBreaker = this.circuitbreaker.circuitBreaker("apuestatotal-api", "apuestatotal-api");
        var retryRunner = this.retry.retry("apuestatotal-api");

        return webClient.method(method)
                .uri(uri)
                .retrieve()
                .bodyToMono(responseType)
                .transform(CircuitBreakerOperator.of(circuitBreaker))
                .transform(RetryOperator.of(retryRunner));
    }

    @SuppressWarnings("null")
    public <T, B> Mono<T> postCallEndpoint(String uri, B body, Class<T> responseType) {

        // Crear un CircuitBreaker
        var circuitBreaker = this.circuitbreaker.circuitBreaker("apuestatotal-api", "apuestatotal-api");
        var retryRunner = this.retry.retry("apuestatotal-api");

        return webClient.post()
                .uri(uri)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(responseType)
                .transform(CircuitBreakerOperator.of(circuitBreaker))
                .transform(RetryOperator.of(retryRunner));
    }

    @SuppressWarnings("null")
    public <T, B> Mono<T> putCallEndpoint(String uri, B body, Class<T> responseType) {

        // Crear un CircuitBreaker
        var circuitBreaker = this.circuitbreaker.circuitBreaker("apuestatotal-api", "apuestatotal-api");
        var retryRunner = this.retry.retry("apuestatotal-api");

        return webClient.put()
                .uri(uri)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(responseType)
                .transform(CircuitBreakerOperator.of(circuitBreaker))
                .transform(RetryOperator.of(retryRunner));
    }

    @SuppressWarnings("null")
    public <T> Mono<T> deleteEndpoint(String uri, Long id, Class<T> responseType) {

        // Crear un CircuitBreaker
        var circuitBreaker = this.circuitbreaker.circuitBreaker("apuestatotal-api", "apuestatotal-api");
        var retryRunner = this.retry.retry("apuestatotal-api");

        return webClient.method(HttpMethod.DELETE)
                .uri(uri +"/"+id)
                .retrieve()
                .bodyToMono(responseType)
                .transform(CircuitBreakerOperator.of(circuitBreaker))
                .transform(RetryOperator.of(retryRunner));
    }
}
