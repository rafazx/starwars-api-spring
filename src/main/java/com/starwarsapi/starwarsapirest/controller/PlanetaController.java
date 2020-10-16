package com.starwarsapi.starwarsapirest.controller;

import java.util.List;

import com.starwarsapi.starwarsapirest.model.Planeta;
import com.starwarsapi.starwarsapirest.services.PlanetaService;
import com.starwarsapi.starwarsapirest.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @Autowired
    private RestService restService;

    @GetMapping
    public ResponseEntity<List<Planeta>> obterTodos() {
        return ResponseEntity.ok(this.planetaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planeta> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(this.planetaService.buscarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Planeta>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(this.planetaService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Planeta> criarPlaneta(@RequestBody Planeta entity) {
        entity.setQtdFilmes(this.restService.pegarTotalFilmes(entity.getNome()));
        return ResponseEntity.ok(this.planetaService.criarPlaneta(entity));
    }
    
    @DeleteMapping("/{id}")
    public String deletarPlaneta(@PathVariable String id) {
        this.planetaService.deletarPlanetaPorId(id);
        return "Planeta Deletado com sucesso";
    }
}
