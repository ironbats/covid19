package com.covid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Global {

    private long newConfirmed;
    private long totalConfirmed;
    private long newDeaths;
    private long totalDeaths;
    private long newRecovered;
    private long totalRecovered;

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
}
