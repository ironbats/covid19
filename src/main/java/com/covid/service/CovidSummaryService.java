package com.covid.service;

import com.covid.domain.CountriesModel;
import com.covid.domain.GlobalModel;
import com.covid.domain.SummaryModel;
import com.covid.dto.Summary;
import com.covid.repository.SummayCovidRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class CovidSummaryService {


    @Autowired
    private SummayCovidRepository summayCovidRepository;

    public void saveSummary(Summary source) {

        SummaryModel target = new SummaryModel();


        List<CountriesModel> countriesModels = Arrays.stream(source.getCountries()).map(countries -> {
            CountriesModel countriesModel = new CountriesModel();
            countriesModel.setCountry(countries.getCountry());
            countriesModel.setCountryCode(countries.getCountryCode());
            countriesModel.setDate(countries.getDate());
            countries.setNewConfirmed(countries.getNewConfirmed());
            countries.setNewDeaths(countries.getNewDeaths());
            countries.setNewRecovered(countries.getNewConfirmed());
            countries.setSlug(countries.getSlug());
            countries.setTotalDeaths(countries.getTotalDeaths());
            countries.setTotalConfirmed(countries.getTotalConfirmed());
            countries.setTotalRecovered(countries.getTotalRecovered());
            return countriesModel;
        }).collect(Collectors.toList());

        GlobalModel globalModel = new GlobalModel();
        globalModel.setNewConfirmed(source.getGlobal().getNewConfirmed());
        globalModel.setNewDeaths(source.getGlobal().getNewDeaths());
        globalModel.setNewRecovered(source.getGlobal().getNewRecovered());
        globalModel.setTotalConfirmed(source.getGlobal().getTotalConfirmed());
        globalModel.setTotalRecovered(source.getGlobal().getTotalRecovered());
        globalModel.setTotalDeaths(source.getGlobal().getTotalDeaths());


        target.setCountries(countriesModels);
        target.setGlobalModel(globalModel);

        try {

            summayCovidRepository.saveAndFlush(globalModel);
            summayCovidRepository.saveAll(countriesModels);
            summayCovidRepository.saveAndFlush(target);

        } catch (Exception cause) {
            log.info(cause.getMessage());
        }


    }
}
