package com.github.luizsac.citiesapi.service;

import com.github.luizsac.citiesapi.entity.Country;
import com.github.luizsac.citiesapi.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    Logger log = LoggerFactory.getLogger(CountryService.class);
    private CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Page<Country> getAllCountries(Pageable page) {
        log.info("getAllCountries");
        return repository.findAll(page);
    }

    public Optional getCountryById(Long id) {
        log.info("getCountryById");
        return repository.findById(id);
    }

}
