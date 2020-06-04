package com.microservices.beerclient.components;

import com.microservices.beerclient.model.BeerDto;
import com.microservices.beerclient.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles(profiles = {"dev"})
@SpringBootTest
class BeerClientTest {

    @Autowired
    private BeerClient beerClient;

    @Test
    void getBeerById() {
        //given
        BeerDto beerDto = beerClient.getBeerById(10L);

        assertNotNull(beerDto);
        assertEquals(1L, (long) beerDto.getId());
    }

    @Test
    void addNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder()
                .beerName("Lech")
                .price(BigDecimal.valueOf(2.33))
                .beerStyleEnum(BeerStyleEnum.LAGER)
                .build();
        //when
        BeerDto result = beerClient.addNewBeer(beerDto);

        //then
        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    void updateBeer() {
        //given
        BeerDto beerDto = beerClient.getBeerById(1L);
        beerDto.setBeerName("new name");

        //when
        beerClient.updateBeer(beerDto);
    }

    @Test
    void deleteBeer() {

        //when
        beerClient.deleteBeer(2L);
    }

}