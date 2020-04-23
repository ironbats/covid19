package com.covid.http;


import com.covid.dto.Country;
import com.covid.dto.CountryDayOne;
import com.covid.dto.Summary;
import com.covid.dto.TotalWorld;
import com.covid.service.Covid19Service;
import com.covid.service.CovidSummaryService;
import com.covid.service.CovidTotalWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/covid")
public class CovidController {


    @Autowired
    private Covid19Service covid19Service;

    @Autowired
    private CovidTotalWorldService covidTotalWorldService;
    @Autowired
    private CovidSummaryService covidSummaryService;

    @PostMapping("/summary")
    public ResponseEntity getSummary() {
        Summary responseEntity = covid19Service.getSummary();
        covidSummaryService.saveSummary(responseEntity);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/country")
    public ResponseEntity getCountries() {
        Country[] responseEntity = covid19Service.getAllCountries();
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/country/dayone/{country}/allstatus")
    public ResponseEntity getDayOneAllStatus(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOneAllStatus(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/country/dayone/{country}/confirmed")
    public ResponseEntity getDayOneConfirmed(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOne(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/country/dayone/{country}/confirmed/live")
    public ResponseEntity getDayOneConfirmedLive(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getCountryDayOneLive(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/country/dayone/{country}/confirmed/live/date")
    public ResponseEntity getLiveCountryAfterDate(@PathVariable String country) {
        CountryDayOne[] responseEntity = covid19Service.getLiveByCountryAfterDate(country);
        return ResponseEntity.ok(responseEntity);
    }

    @PostMapping("/total-world")
    public ResponseEntity getTotalWorld() {
        TotalWorld responseEntity = covid19Service.getTotalWorld();

        covidTotalWorldService.saveTotalRepository(responseEntity);
        return ResponseEntity.ok(responseEntity);
    }


}
