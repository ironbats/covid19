package com.covid.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GlobalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long newConfirmed;
    private long totalConfirmed;
    private long newDeaths;
    private long totalDeaths;
    private long newRecovered;
    private long totalRecovered;

}
