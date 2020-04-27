package com.covid.http;


import com.covid.dto.*;
import com.covid.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PutMapping("/countries")
    public ResponseEntity getCountries() {
        Country[] countries = covid19Service.getAllCountries();
        countryService.saveSampleCountry(countries);
        return ResponseEntity.ok(countries);
    }

    @PutMapping("/country/dayone/country/allstatus")
    public ResponseEntity getDayOneAllStatus() {

        List<FallbackDTO> listOfFallbacks = new ArrayList<>();

        countryService.countryCode().forEach(code -> {
            try {
                CountryDayOne[] countriesDayOne = covid19Service.getCountryDayOneAllStatus(code);
                countryService.saveCountryDayOneAllStatus(countriesDayOne);
            } catch (Exception cause) {
                log.warn(cause.getMessage() + "    " + code);
                FallbackDTO fallbackDTO = new FallbackDTO();
                fallbackDTO.setCountryCode(code);
                fallbackDTO.setMessageError(cause.getMessage());
                listOfFallbacks.add(fallbackDTO);
            }
        });

        try {
            fallBackService.saveFallBackCountries(listOfFallbacks);
        } catch (Exception cause) {
            log.warn(cause.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/country/dayone/{country}/confirmed")
    public ResponseEntity getDayOneConfirmed(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOne(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PutMapping("/country/dayone/{country}/confirmed/live")
    public ResponseEntity getDayOneConfirmedLive(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOneLive(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PutMapping("/country/dayone/{country}/confirmed/live/date")
    public ResponseEntity getLiveCountryAfterDate(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getLiveByCountryAfterDate(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PutMapping("/total-world")
    public ResponseEntity getTotalWorld() {
        TotalWorld responseEntity = covid19Service.getTotalWorld();

        covidTotalWorldService.saveTotalRepository(responseEntity);
        return ResponseEntity.ok(responseEntity);
    }


}
