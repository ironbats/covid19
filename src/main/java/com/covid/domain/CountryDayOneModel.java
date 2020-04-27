package com.covid.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CountryDayOneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String countryCode;
    private String lat;
    private String lon;
    private String status;
    private String date;
    private String Province;
    private String City;
    private long Confirmed;
    private long Deaths;
    private long Recovered;
}
