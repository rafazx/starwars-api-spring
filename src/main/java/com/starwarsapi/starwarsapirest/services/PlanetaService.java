package com.starwarsapi.starwarsapirest.services;

import java.util.List;

import com.starwarsapi.starwarsapirest.model.Planeta;


public interface PlanetaService {

    public Planeta criarPlaneta(Planeta planeta);
    public List<Planeta> obterTodos();
    public List<Planeta> buscarPorNome(String nome); 
    public Planeta buscarPorId(String id);
    public void deletarPlanetaPorId(String id);

}
