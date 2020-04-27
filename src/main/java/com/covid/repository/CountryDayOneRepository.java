package com.covid.repository;

import com.covid.domain.CountryDayOneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDayOneRepository extends JpaRepository<CountryDayOneModel,Long> {
}
