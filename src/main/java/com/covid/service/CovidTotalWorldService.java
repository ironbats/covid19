package com.covid.service;

import com.covid.domain.TotalWorldModel;
import com.covid.dto.TotalWorld;
import com.covid.repository.TotalWorldRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class CovidTotalWorldService {

    @Autowired
    private TotalWorldRepository totalWorldRepository;

    public void saveTotalRepository(TotalWorld source) {


        TotalWorldModel target = new TotalWorldModel();
        source.setTotalConfirmed(source.getTotalConfirmed());
        source.setTotalDeaths(source.getTotalDeaths());
        source.setTotalRecovered(source.getTotalRecovered());

        try {
            totalWorldRepository.saveAndFlush(target);
        } catch (Exception cause) {
            log.warn(cause.getMessage());
        }

    }
}
