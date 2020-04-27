package com.covid.service;

import com.covid.domain.CountryDayOneModel;
import com.covid.domain.CountryModel;
import com.covid.dto.Country;
import com.covid.dto.CountryDayOne;
import com.covid.repository.CountryDayOneRepository;
import com.covid.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryDayOneRepository countryDayOneRepository;


    public List<String> countryCode() {
        return countryRepository.findAll()
                .stream().map(CountryModel::getCountry).collect(Collectors.toList());
    }

    public void saveSampleCountry(Country[] country) {

        List<CountryModel> countries = Arrays.stream(country).map(c -> {
            CountryModel countyModel = new CountryModel();
            countyModel.setCountry(c.getCountry());
            countyModel.setIso2(c.getIso2());
            countyModel.setSlug(c.getSlug());
            return countyModel;
        }).collect(Collectors.toList());

        try {
            countryRepository.saveAll(countries);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public List<CountryDayOne> getAllStatusCountriesDayOne() {
        return countryDayOneRepository.findAll().stream().map(countries -> {
            CountryDayOne countryDayOne = new CountryDayOne(
                    countries.getCountry(),
                    countries.getCountryCode(),
                    countries.getLat(),
                    countries.getLon(),
                    countries.getStatus(),
                    countries.getDate(),
                    countries.getProvince(),
                    countries.getCity(),
                    countries.getConfirmed(),
                    countries.getDeaths(),
                    countries.getRecovered());
            return countryDayOne;
        }).collect(Collectors.toList());
    }
}
