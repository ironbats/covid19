package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalWorld {

    private long totalConfirmed;
    private long totalDeaths;
    private long totalRecovered;

    @JsonProperty("TotalConfirmed")
    public long getTotalConfirmed() { return totalConfirmed; }
    @JsonProperty("TotalConfirmed")
    public void setTotalConfirmed(long value) { this.totalConfirmed = value; }

    @JsonProperty("TotalDeaths")
    public long getTotalDeaths() { return totalDeaths; }
    @JsonProperty("TotalDeaths")
    public void setTotalDeaths(long value) { this.totalDeaths = value; }

    @JsonProperty("TotalRecovered")
    public long getTotalRecovered() { return totalRecovered; }
    @JsonProperty("TotalRecovered")
    public void setTotalRecovered(long value) { this.totalRecovered = value; }
}
