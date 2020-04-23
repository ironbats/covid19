package com.covid.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SummaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private GlobalModel globalModel;
    @OneToMany
    private List<CountriesModel> countries;
}
