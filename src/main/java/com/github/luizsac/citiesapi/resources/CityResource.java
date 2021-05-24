package com.github.luizsac.citiesapi.resources;

import com.github.luizsac.citiesapi.entity.City;
import com.github.luizsac.citiesapi.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    Logger log = LoggerFactory.getLogger(CityService.class);
    private CityService service;

    public CityResource(CityService service) {
        this.service = service;
    }

    @GetMapping
    public Page<City> getCities(Pageable page) {
        log.info("getCities");
        return service.getAllCities(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCity(@PathVariable Long id) {
        log.info("getCity");
        Optional cityOptional = service.getCityById(id);
        if (cityOptional.isPresent()) {
            return ResponseEntity.ok().body(cityOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

}
