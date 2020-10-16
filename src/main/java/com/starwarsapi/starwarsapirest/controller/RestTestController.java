package com.starwarsapi.starwarsapirest.controller;

import com.starwarsapi.starwarsapirest.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestTestController {

    @Autowired
    private RestService restService;

    @GetMapping() 
    public Number getMethodName() {
        String name = "Serenno";
        String uri = "https://swapi.dev/api/planets/?page=";
        return  this.restService.pegarTotalFilmes(name, uri);
    }
    
}
