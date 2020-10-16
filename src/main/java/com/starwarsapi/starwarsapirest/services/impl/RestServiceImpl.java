package com.starwarsapi.starwarsapirest.services.impl;

import com.starwarsapi.starwarsapirest.model.Response;
import com.starwarsapi.starwarsapirest.model.ResponseList;
import com.starwarsapi.starwarsapirest.services.RestService;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Exp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService {
    private final RestTemplate restTemplate;
    private final String uri = "https://swapi.dev/api/planets/?page=";
    public Integer page = 1;

    public RestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Integer pegarTotalFilmes(String nomePlaneta) {
        try {
            ResponseEntity<ResponseList> entity = this.restTemplate.getForEntity(this.uri + this.page, ResponseList.class);
            ResponseList entityes = entity.getBody();
            return this.percorrerArray(entityes, nomePlaneta);
        }catch(Exception e) {
            throw e;
        }
    }

    private Integer percorrerArray(ResponseList entityes, String nomePlaneta) {
        for (Response resp: entityes.getResults()) {
            System.out.println(resp.getName());
            if(resp.getName().equals(nomePlaneta)) {
                this.page = 1;
                return resp.getFilms().size();
            }
        };
        this.page++;
        if(this.page == 7) {
            this.page = 1;
            return 0;
        }
        return this.pegarTotalFilmes(nomePlaneta);
    }
}
