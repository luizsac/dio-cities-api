package com.github.luizsac.citiesapi.repository;

import com.github.luizsac.citiesapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {}
