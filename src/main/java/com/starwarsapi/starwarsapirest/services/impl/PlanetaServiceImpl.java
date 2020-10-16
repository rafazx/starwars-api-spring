package com.starwarsapi.starwarsapirest.services.impl;

import java.util.List;

import com.starwarsapi.starwarsapirest.model.Planeta;
import com.starwarsapi.starwarsapirest.repository.PlanetaRepository;
import com.starwarsapi.starwarsapirest.services.PlanetaService;
import com.starwarsapi.starwarsapirest.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlanetaServiceImpl implements PlanetaService {

    private String uri = "http://swapi.dev/api/planets/?page=";

    @Autowired
    private PlanetaRepository planetaRepository;

    @Override
    public List<Planeta> obterTodos() {
        return this.planetaRepository.findAll();
    }

    @Override
    public List<Planeta> buscarPorNome(String nome) {
        return this.planetaRepository
                .findByNome(nome)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi achado planeta com esse Nome"));
    }

    @Override
    public Planeta buscarPorId(String id) {
        return this.planetaRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi achado planeta com esse id"));
    }

    @Override
    public void deletarPlanetaPorId(String id) {
            this.buscarPorId(id);
            this.planetaRepository.deleteById(id);
    }

    @Override
    public Planeta criarPlaneta(Planeta planeta) {
        System.out.println(planeta);
        return this.planetaRepository.save(planeta);
    }
    
}
