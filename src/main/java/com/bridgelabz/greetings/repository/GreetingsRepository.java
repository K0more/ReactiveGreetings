package com.bridgelabz.greetings.repository;


import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.bridgelabz.greetings.model.Greetings;

public interface GreetingsRepository extends R2dbcRepository<Greetings,Integer> {

}