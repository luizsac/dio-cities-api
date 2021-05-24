package com.github.luizsac.citiesapi.service;

import com.github.luizsac.citiesapi.entity.City;
import com.github.luizsac.citiesapi.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    Logger log = LoggerFactory.getLogger(CityService.class);
    private CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public Page<City> getAllCities(Pageable page) {
        log.info("getAllCities");
        return repository.findAll(page);
    }

    public Optional getCityById(Long id) {
        log.info("getCityById");
        return repository.findById(id);
    }

}
