package com.covid.domain;


import lombok.Data;
import org.hibernate.validator.internal.util.stereotypes.Immutable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country_model")
public class CountryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    @Immutable
    private String country;
    private String slug;
    @Immutable
    @Column(unique = true)
    private String iso2;

}
