package com.github.luizsac.citiesapi.service;

import com.github.luizsac.citiesapi.entity.City;
import com.github.luizsac.citiesapi.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    private final CityRepository repository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(CityRepository repository) {
        this.repository = repository;
    }

    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        log.info("nativePostgresInMiles({}, {})", city1, city2);
        return repository.distanceByPoints(city1, city2);
    }

    public Double distanceByCubeInMeters(Long city1, Long city2) {
        log.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = repository.findAllById((Arrays.asList(city1, city2)));

        Point p1 = cities.get(0).getGeolocation();
        Point p2 = cities.get(1).getGeolocation();

        return repository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

}
