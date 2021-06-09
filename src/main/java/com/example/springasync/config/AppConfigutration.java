package com.example.springasync.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@EnableAutoConfiguration
public class AppConfigutration {

    @Bean
    public RouterFunction<?> helloRouterFunc() {
        return RouterFunctions.route(RequestPredicates.GET("/hello"),
                serverRequest -> ServerResponse.ok().body(Mono.just("Hello World!!!"),
                        new ParameterizedTypeReference<Mono<? super String>>() {}));
    }
}
