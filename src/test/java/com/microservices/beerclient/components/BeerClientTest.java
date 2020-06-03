package com.microservices.beerclient.components;

import com.microservices.beerclient.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//@IfProfileValue(name = "spring.profiles.active", values = {"dev"})
@ActiveProfiles(profiles = {"dev"})
@SpringBootTest
class BeerClientTest {

    @Autowired
    private BeerClient beerClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = beerClient.getBeerById(1L);

        assertNotNull(beerDto);
        assertEquals(1L, (long) beerDto.getId());
    }
}