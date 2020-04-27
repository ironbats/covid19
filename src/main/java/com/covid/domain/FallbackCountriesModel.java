package com.covid.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "fallbackCountries")
@Data
public class FallbackCountriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String countryCode;
    private String messageError;
}
