package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Countries {

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

    @JsonProperty("Country")
    public String getCountry() { return country; }
    @JsonProperty("Country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("CountryCode")
    public String getCountryCode() { return countryCode; }
    @JsonProperty("CountryCode")
    public void setCountryCode(String value) { this.countryCode = value; }

    @JsonProperty("Slug")
    public String getSlug() { return slug; }
    @JsonProperty("Slug")
    public void setSlug(String value) { this.slug = value; }

    @JsonProperty("NewConfirmed")
    public long getNewConfirmed() { return newConfirmed; }
    @JsonProperty("NewConfirmed")
    public void setNewConfirmed(long value) { this.newConfirmed = value; }

    @JsonProperty("TotalConfirmed")
    public long getTotalConfirmed() { return totalConfirmed; }
    @JsonProperty("TotalConfirmed")
    public void setTotalConfirmed(long value) { this.totalConfirmed = value; }

    @JsonProperty("NewDeaths")
    public long getNewDeaths() { return newDeaths; }
    @JsonProperty("NewDeaths")
    public void setNewDeaths(long value) { this.newDeaths = value; }

    @JsonProperty("TotalDeaths")
    public long getTotalDeaths() { return totalDeaths; }
    @JsonProperty("TotalDeaths")
    public void setTotalDeaths(long value) { this.totalDeaths = value; }

    @JsonProperty("NewRecovered")
    public long getNewRecovered() { return newRecovered; }
    @JsonProperty("NewRecovered")
    public void setNewRecovered(long value) { this.newRecovered = value; }

    @JsonProperty("TotalRecovered")
    public long getTotalRecovered() { return totalRecovered; }
    @JsonProperty("TotalRecovered")
    public void setTotalRecovered(long value) { this.totalRecovered = value; }

    @JsonProperty("Date")
    public String getDate() { return date; }
    @JsonProperty("Date")
    public void setDate(String value) { this.date = value; }
}
