package com.starwarsapi.starwarsapirest.repository;

import java.util.List;
import java.util.Optional;

import com.starwarsapi.starwarsapirest.model.Planeta;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
    public Optional<List<Planeta>> findByNome(String nome);
}
