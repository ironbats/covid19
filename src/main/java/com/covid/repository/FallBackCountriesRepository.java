package com.covid.repository;

import com.covid.domain.FallbackCountriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FallBackCountriesRepository extends JpaRepository<FallbackCountriesModel,Long> {
}
