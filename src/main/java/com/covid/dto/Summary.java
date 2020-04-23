package com.covid.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Summary {

    private Global global;
    private Countries[] countries;

    @JsonProperty("Global")
    public Global getGlobal() { return global; }
    @JsonProperty("Global")
    public void setGlobal(Global value) { this.global = value; }

    @JsonProperty("Countries")
    public Countries[] getCountries() { return countries; }
    @JsonProperty("Countries")
    public void setCountries(Countries[] value) { this.countries = value; }
}