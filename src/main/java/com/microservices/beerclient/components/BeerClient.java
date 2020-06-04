package com.microservices.beerclient.components;

import com.microservices.beerclient.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@ConfigurationProperties(value = "beer") //this + setter method would not need @Value to inject property
public class BeerClient {

    private final String apiHost;
    public final String BEER_URI_V1 = "/api/v1/beer/";

    private final RestTemplate restTemplate;

    @Autowired
    public BeerClient(@Value("${beer.apiHost}") String apiHost, RestTemplateBuilder restTemplateBuilder) {
        this.apiHost = apiHost;
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(Long id) {
        return restTemplate.getForObject(apiHost + BEER_URI_V1 + id.toString(), BeerDto.class);
    }

    public BeerDto addNewBeer(BeerDto beerDto) {
        HttpEntity<BeerDto> request = new HttpEntity<>(beerDto);
        return restTemplate.postForObject(apiHost + BEER_URI_V1, request, BeerDto.class);
    }

    public void updateBeer(BeerDto beerDto) {
        HttpEntity<BeerDto> request = new HttpEntity<>(beerDto);
        restTemplate.put(apiHost + BEER_URI_V1, request, BeerDto.class);
    }

    public void deleteBeer(Long id) {
        restTemplate.delete(apiHost + BEER_URI_V1 + id);
    }
}
