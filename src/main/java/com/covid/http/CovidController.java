package com.covid.http;


import com.covid.dto.*;
import com.covid.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/covid")
@Slf4j
public class CovidController {

    @Autowired
    private Covid19Service covid19Service;

    @Autowired
    private CovidTotalWorldService covidTotalWorldService;
    @Autowired
    private CovidSummaryService covidSummaryService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private FallBackService fallBackService;

    @PutMapping("/summary")
    public ResponseEntity getSummary() {
        Summary responseEntity = covid19Service.getSummary();
        covidSummaryService.saveSummary(responseEntity);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/countries")
    public ResponseEntity getCountries() {
        Country[] countries = covid19Service.getAllCountries();
        countryService.saveSampleCountry(countries);
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/country/dayone/{country}/allstatus")
    public ResponseEntity getDayOneAllStatus(@PathVariable String country) {

        CountryDayOne[] countriesDayOne = null;
        try {
            countriesDayOne = covid19Service.getCountryDayOneAllStatus(country);

        } catch (Exception cause) {

            List<CountryDayOne> countryDayOnes =
                    countryService.getAllStatusCountriesDayOne().
                            stream()
                            .filter(c -> c.equals(country))
                            .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(countryDayOnes)) {
                return ResponseEntity.ok(countriesDayOne);
            }
            log.warn("Problem to search Api !" + cause.getMessage());
            return ResponseEntity.badRequest().body(cause.getMessage() + " Problem with this country " + country);
        }
        return ResponseEntity.ok(countriesDayOne);
    }

    @GetMapping("/country/dayone/{country}/confirmed")
    public ResponseEntity getDayOneConfirmed(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOne(country);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/country/dayone/{country}/deaths")
    public ResponseEntity getDayOneDeaths(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOne(country);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/country/dayone/{country}/recovered")
    public ResponseEntity getDayOneRecovered(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOne(country);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/country/dayone/{country}/confirmed/live")
    public ResponseEntity getDayOneConfirmedLive(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOneLive(country);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/country/dayone/{country}/confirmed/live/date")
    public ResponseEntity getLiveCountryAfterDate(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getLiveByCountryAfterDate(country);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/total-world")
    public ResponseEntity getTotalWorld() {
        TotalWorld responseEntity = covid19Service.getTotalWorld();

        covidTotalWorldService.saveTotalRepository(responseEntity);
        return ResponseEntity.ok(responseEntity);
    }


}
