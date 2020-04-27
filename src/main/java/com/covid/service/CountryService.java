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

    public void saveCountryDayOneAllStatus(CountryDayOne[] countryDayOne) {

        List<CountryDayOneModel> countryDayOneModels = new ArrayList<>();

        try {

            countryDayOneModels = Arrays.stream(countryDayOne)
                    .map(c -> {
                        CountryDayOneModel countryDayOneModel = new CountryDayOneModel();
                        countryDayOneModel.setConfirmed(c.getConfirmed());
                        countryDayOneModel.setDeaths(c.getDeaths());
                        countryDayOneModel.setRecovered(c.getRecovered());
                        countryDayOneModel.setProvince(c.getProvince());
                        countryDayOneModel.setCity(c.getCity());
                        countryDayOneModel.setCountry(c.getCountry());
                        countryDayOneModel.setDate(c.getDate());
                        countryDayOneModel.setLat(c.getLat());
                        countryDayOneModel.setLon(c.getLon());
                        countryDayOneModel.setCountryCode(c.getCountryCode());
                        return countryDayOneModel;
                    }).collect(Collectors.toList());

        } catch (Exception cause) {
            log.warn(cause.getMessage());
        }


        try {
            countryDayOneRepository.saveAll(countryDayOneModels);
        } catch (Exception cause) {
            log.error(cause.getMessage());
        }
    }

}
