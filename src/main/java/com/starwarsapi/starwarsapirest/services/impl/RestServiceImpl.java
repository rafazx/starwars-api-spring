package com.starwarsapi.starwarsapirest.services.impl;

import com.starwarsapi.starwarsapirest.model.Response;
import com.starwarsapi.starwarsapirest.model.ResponseList;
import com.starwarsapi.starwarsapirest.services.RestService;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceImpl implements RestService {
    private final RestTemplate restTemplate;

    public Integer page = 1;

    public RestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Integer pegarTotalFilmes(String nomePlaneta, String uri) {
        ResponseEntity<ResponseList> entity = this.restTemplate.getForEntity(uri + this.page, ResponseList.class);
        ResponseList entityes = entity.getBody();
        return this.percorrerArray(entityes, nomePlaneta, uri);
    }

    private Integer percorrerArray(ResponseList entityes, String nomePlaneta, String uri) {
        for (Response resp: entityes.getResults()) {
            System.out.println(resp.getName());
            if(resp.getName().equals(nomePlaneta)) {
                return resp.getFilms().size();
            }
        };
        this.page++;
        return this.pegarTotalFilmes(nomePlaneta, uri);
    }
}
