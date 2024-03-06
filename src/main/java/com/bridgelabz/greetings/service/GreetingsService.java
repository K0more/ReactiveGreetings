package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.model.Greetings;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GreetingsService {
    Mono<Greetings> saveGreeting(Greetings greeting);

    Flux<Greetings> getGreeting();
    Mono<Greetings> getGreetingById(long id);
    Mono<Greetings> deleteGreetingById(long id);
}
