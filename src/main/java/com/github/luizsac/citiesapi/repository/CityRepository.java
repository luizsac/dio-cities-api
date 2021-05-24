package com.github.luizsac.citiesapi.repository;

import com.github.luizsac.citiesapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id = ?1) <@>" +
            "(SELECT lat_lon FROM cidade WHERE id = ?2)) as distance;", nativeQuery = true)
    Double distanceByPoints(Long city1, Long city2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) AS distance;", nativeQuery = true)
    Double distanceByCube(double x1, double y1, double x2, double y2);

    @Query(value = "SELECT * FROM cidade WHERE nome ILIKE ?1", nativeQuery = true)
    Optional<City> findByName(String name);
}
