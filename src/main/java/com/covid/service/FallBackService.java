package com.covid.service;

import com.covid.domain.FallbackCountriesModel;
import com.covid.dto.FallbackDTO;
import com.covid.repository.FallBackCountriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FallBackService {

    @Autowired
    private FallBackCountriesRepository fallBackCountriesRepository;

    public void saveFallBackCountries(List<FallbackDTO> fallBackList) {

        try {

            List<FallbackCountriesModel> fallback = fallBackList.stream()
                    .map(x -> {
                        FallbackCountriesModel fallbackCountriesModel = new FallbackCountriesModel();
                        fallbackCountriesModel.setCountryCode(x.getCountryCode());
                        fallbackCountriesModel.setMessageError(x.getMessageError());
                        return fallbackCountriesModel;
                    }).collect(Collectors.toList());


            fallBackCountriesRepository.saveAll(fallback);

        } catch (Exception cause) {
            log.warn(cause.getMessage());
        }
    }
}
