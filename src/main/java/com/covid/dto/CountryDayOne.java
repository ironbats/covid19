package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDayOne {


    public CountryDayOne(){}

    public CountryDayOne(String country, String countryCode, String lat, String lon, String status, String date, String province, String city, long confirmed, long deaths, long recovered) {
        this.country = country;
        this.countryCode = countryCode;
        this.lat = lat;
        this.lon = lon;
        this.status = status;
        this.date = date;
        Province = province;
        City = city;
        Confirmed = confirmed;
        Deaths = deaths;
        Recovered = recovered;
    }

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


    @JsonProperty("City")
    public String getCity() {
        return City;
    }

    @JsonProperty("Province")
    public String getProvince() {
        return Province;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setProvince(String province) {
        Province = province;
    }

    @JsonProperty("Recovered")
    public long getRecovered() {
        return Recovered;
    }

    public void setRecovered(long recovered) {
        Recovered = recovered;
    }

    @JsonProperty("Deaths")
    public long getDeaths() {
        return Deaths;
    }

    public void setDeaths(long deaths) {
        Deaths = deaths;
    }

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

    @JsonProperty("Confirmed")
    public long getConfirmed() { return Confirmed; }
    @JsonProperty("Confirmed")
    public void setConfirmed(long value) { this.Confirmed = value; }

    @JsonProperty("Status")
    public String getStatus() { return status; }
    @JsonProperty("Status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("Date")
    public String getDate() { return date; }
    @JsonProperty("Date")
    public void setDate(String value) { this.date = value; }

}
