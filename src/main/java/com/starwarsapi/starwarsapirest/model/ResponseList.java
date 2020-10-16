package com.starwarsapi.starwarsapirest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseList {
  
    private List<Response> results;

    public ResponseList(List<Response> results, String name) {
		this.results = results;
	}
    
}
