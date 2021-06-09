package com.example.springasync;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

//@SpringBootTest
class SpringAsyncApplicationTests {

    @Test
    void contextLoads() {
        Flux<String> flux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .delayElements(Duration.ofSeconds(1)).take(Duration.ofSeconds(5));
        flux.subscribe(System.out::println);
//        StepVerifier.create(flux).expectNext("Banana", "Strawberry").verifyComplete();
    }

}
