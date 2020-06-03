package com.microservices.beerclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data //getters setters equals hashcode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    private Long id;
    private Integer version;
    private LocalDate createDate;
    private LocalDate lastModifiedDate;
    private String beerName;
    private BeerStyleEnum beerStyleEnum;
    private BigDecimal price;
}
