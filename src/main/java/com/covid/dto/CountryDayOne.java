package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDayOne {

    private String country;
    private String countryCode;
    private String lat;
    private String lon;
    private long cases;
    private String status;
    private String date;

    @JsonProperty("Country")
    public String getCountry() { return country; }
    @JsonProperty("Country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("CountryCode")
    public String getCountryCode() { return countryCode; }
    @JsonProperty("CountryCode")
    public void setCountryCode(String value) { this.countryCode = value; }

    @JsonProperty("Lat")
    public String getLat() { return lat; }
    @JsonProperty("Lat")
    public void setLat(String value) { this.lat = value; }

    @JsonProperty("Lon")
    public String getLon() { return lon; }
    @JsonProperty("Lon")
    public void setLon(String value) { this.lon = value; }

    @JsonProperty("Cases")
    public long getCases() { return cases; }
    @JsonProperty("Cases")
    public void setCases(long value) { this.cases = value; }

    @JsonProperty("Status")
    public String getStatus() { return status; }
    @JsonProperty("Status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("Date")
    public String getDate() { return date; }
    @JsonProperty("Date")
    public void setDate(String value) { this.date = value; }

}
