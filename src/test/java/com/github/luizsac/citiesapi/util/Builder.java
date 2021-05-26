package com.github.luizsac.citiesapi.util;

import com.github.luizsac.citiesapi.entity.City;
import com.github.luizsac.citiesapi.entity.Country;
import com.github.luizsac.citiesapi.entity.State;
import org.springframework.data.geo.Point;

import java.util.Arrays;

public abstract class Builder {

    public static Country buildCountry() {
        return new Country(1L, "Brazil", "Brasil", "BR", 1058);
    }

    public static State buildState() {
        return new State(
                11L, "Minas Gerais", "MG", 31, buildCountry(), Arrays.asList(31, 32, 33, 34, 35, 37, 38));
    }

    public static City buildCity() {
        return new City(
                1692L, "Cana Verde", buildState(), 3111903, new Point(-21.0231990814209, -45.1800994873047));
    }

}
