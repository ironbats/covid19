package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Country {

    @JsonProperty(value = "Country")
    private String country;
    @JsonProperty(value = "Slug")
    private String slug;
    @JsonProperty(value = "ISO2")
    private String iso2;

}
