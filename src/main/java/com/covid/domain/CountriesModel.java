package com.covid.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CountriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String countryCode;
    private String slug;
    private long newConfirmed;
    private long totalConfirmed;
    private long newDeaths;
    private long totalDeaths;
    private long newRecovered;
    private long totalRecovered;
    private String date;

}
