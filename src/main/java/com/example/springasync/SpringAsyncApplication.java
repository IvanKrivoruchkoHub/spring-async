package com.example.springasync;

import com.example.springasync.entities.Ingredient;
import com.example.springasync.repositories.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.Logger;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class SpringAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAsyncApplication.class, args);
//        Flux<String> flux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry", "");
//        flux.buffer(4).subscribe(e -> log.info("{}", e));
//        flux.filter(s -> !s.isEmpty()).log().flatMap(m -> {
//            return Mono.just(m).subscribeOn(Schedulers.parallel());
//        }).subscribe(e -> log.info("{}", e));
//        flux.delaySubscription(Duration.ofSeconds(1)).delayElements(Duration.ofMillis(1000)).log().subscribe(e -> log.info("{}", e));
//        Flux<String> flux = Flux.just("Apple", "Apple", "Grape", "Apple", "Strawberry");
//        flux.buffer(2).subscribe(System.out::println);
//        Flux.just(
//                "apple", "orange", "banana", "kiwi", "strawberry")
//                .buffer(3)
//                .flatMap(x ->
//                        Flux.fromIterable(x)
//                                .map(String::toUpperCase)
//                                .subscribeOn(Schedulers.parallel())
//                                .log()
//                )
//                .subscribe();
//        Flux.just(
//                "apple", "orange", "banana", "kiwi", "strawberry")
//                .map(m -> m.substring(0, 2))
//                .log()
//                .buffer(3)
//                .flatMap(x ->
//                        Flux.fromIterable(x)
//                                .map(String::toUpperCase)
//                                .subscribeOn(Schedulers.parallel())
//                                .log()
//                ).subscribe();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Flux<String> flux2 = Flux.range(0, 4).map(Object::toString);
//        Flux.firstWithSignal(flux, flux2).subscribe(s -> log.info("{}", s));
//        flux.mergeWith(flux2).log().subscribe(s -> log.info("{}", s));
    }

    @Bean
    @ConditionalOnProperty(prefix = "spring.datasource", value = "init", havingValue = "true")
    public ApplicationRunner getApplicationRunner(IngredientRepository ingredientRepository) {
        return args -> {
            ingredientRepository.saveAll(Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                    new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                    new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                    new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                    new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                    new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                    new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                    new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                    new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                    new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)));
        };
    }
}
