package com.github.luizsac.citiesapi.service;

import com.github.luizsac.citiesapi.entity.Country;
import com.github.luizsac.citiesapi.repository.CountryRepository;
import com.github.luizsac.citiesapi.util.Builder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CountryServiceTest {

    @Mock
    private CountryRepository repository;

    @InjectMocks
    private CountryService service;

    @Test
    void whenGetAllCountriesIsCalledReturnPageOfCountries() {
        //given
        List<Country> countries = new ArrayList<>();
        countries.add(Builder.buildCountry());
        Page<Country> expectedCountriesPage = new PageImpl<>(countries);
        Pageable page = PageRequest.of(0, 20);

        // when
        when(service.getAllCountries(page)).thenReturn(expectedCountriesPage);

        // then
        Page<Country> foundCountriesPage = service.getAllCountries(page);
        System.out.println("Page: " + foundCountriesPage);
        assertThat(foundCountriesPage, is(equalTo(expectedCountriesPage)));
    }

}
