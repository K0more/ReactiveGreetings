package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.model.Greetings;
import com.bridgelabz.greetings.service.GreetingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GreetingsController {

    @Autowired
    GreetingsService greetingService;

    @PostMapping("/greets")
    public Mono<HttpResponse> saveGreets(@RequestBody Greetings greets) {
        return greetingService.saveGreeting(greets)
                .map(savedGreet -> new HttpResponse("Success", "Greeting saved successfully"));
    }

    @GetMapping("/greets")
    public Flux<Greetings> getGreetings() {
        return greetingService.getGreeting();
    }

    @GetMapping("/greets/{greetId}")
    public Mono<Greetings> getGreetingById(@PathVariable String greetId) {
        return greetingService.getGreetingById(Long.parseLong(greetId));
    }

    @DeleteMapping("/greets/{greetId}")
    public Mono<HttpResponse> deleteGreetingsById(@PathVariable String greetId) {
        return greetingService.deleteGreetingById(Long.parseLong(greetId))
                .map(deletedGreet -> new HttpResponse("Success", "Greeting deleted successfully"));
    }
}