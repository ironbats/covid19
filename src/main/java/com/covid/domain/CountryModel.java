package com.covid.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country_model")
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String slug;
    private String iso2;

}
