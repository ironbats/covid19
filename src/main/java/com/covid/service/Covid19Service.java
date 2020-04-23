package com.covid.service;

import com.covid.dto.Country;
import com.covid.dto.CountryDayOne;
import com.covid.dto.Summary;
import com.covid.dto.TotalWorld;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "covid", url = ("${api.covid.request}"))
public interface Covid19Service {

    /**
     * A summary of new and total cases per country updated daily.
     *
     * @return
     */
    @GetMapping("/summary")
    Summary getSummary();

    /**
     * Returns all the available countries and provinces,
     * as well as the country slug for per country requests.
     *
     * @return
     */
    @GetMapping("/countries")
    Country[] getAllCountries();

    /**
     * Returns all cases by case type for a country from the first recorded case.
     * Country must be the Slug from
     * /countries or /summary. Cases must be one of: confirmed, recovered, deaths
     *
     * @param country
     * @return
     */
    @GetMapping("/country/{country}")
    CountryDayOne[] getCountryDayOneAllStatus(@PathVariable String country);

    /**
     * Returns all cases by case type for a country from the first
     * recorded case. Country must be the Slug from
     * /countries or /summary. Cases must be one of: confirmed, recovered, deaths
     *
     * @param country
     * @return
     */
    @GetMapping("/country/{country}/status/confirmed")
    CountryDayOne[] getCountryDayOne(@PathVariable String country);

    /**
     * Returns all cases by case type for a country from the first recorded case with the latest
     * record being the live count. Country must be the Slug from
     * /countries or /summary. Cases must be one of: confirmed, recovered, deaths
     *
     * @param country
     * @return
     */
    @GetMapping("/country/{country}/status/confirmed/live")
    CountryDayOne[] getCountryDayOneLive(@PathVariable String country);

    /**
     * Returns all live cases by case type for a country after a given date.
     * These records are pulled every 10 minutes and are ungrouped.
     * Country must be the slug from /countries or /summary.
     * Cases must be one of: confirmed, recovered, deaths
     *
     * @param date
     * @return
     */
    @GetMapping("/country/{country}/status/confirmed/date/{date}")
    CountryDayOne[] getLiveByCountryAfterDate(@PathVariable String date);

    /**
     * Returns all live cases by case type for a country after a given date.
     * These records are pulled every 10 minutes and are ungrouped.
     * Country must be the slug from /countries or /summary.
     * Cases must be one of: confirmed, recovered, deaths
     *
     * @return
     */
    @GetMapping("/world/total")
    TotalWorld getTotalWorld();


}
