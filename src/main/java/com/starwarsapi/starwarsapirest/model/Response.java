package com.starwarsapi.starwarsapirest.model;

import java.util.List;

import lombok.Data;

@Data
public class Response {

    private String name;

    private List<String> films;

}
