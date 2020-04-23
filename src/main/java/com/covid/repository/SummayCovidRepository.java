package com.covid.repository;

import com.covid.domain.SummaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummayCovidRepository<T extends  SummaryModel> extends JpaRepository<T, Long> {
}
