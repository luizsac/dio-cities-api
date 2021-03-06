package com.github.luizsac.citiesapi.resources;

import com.github.luizsac.citiesapi.entity.Country;
import com.github.luizsac.citiesapi.repository.CountryRepository;
import com.github.luizsac.citiesapi.service.CountryService;
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

@RestController // é um controlador do tipo REST
@RequestMapping("/countries") // mapeia a classe para o endereço http://localhost:8080/countries
public class CountryResource {

    private Logger log = LoggerFactory.getLogger(CountryResource.class);
    private CountryService service;

    public CountryResource(CountryService service) {
        this.service = service;
    }

    // Pageable serve para paginar os dados recuperados do banco
    // No endereço da aplicação, parâmetros podem ser passados para modificar o comportamento da paginação
    // ex.: localhost:8080/countries?page=0&size=10&sort=name,asc
    @GetMapping //mapeia método para o verbo GET
    public ResponseEntity<Page<Country>> getCountries(Pageable page) {
        log.info("getCountries");
        return ResponseEntity.ok().body(service.getAllCountries(page));
    }

    @GetMapping("/{id}") // {} indica que valor é um parâmetro
    public ResponseEntity getCountry(@PathVariable Long id) { // captura o parâmetro passado através do endereço
        log.info("getCountry");
        Optional countryOptional = service.getCountryById(id);
        if(countryOptional.isPresent()) {
            return ResponseEntity.ok().body(countryOptional.get()); // cria um response com o código 200 e o país
        }
        return ResponseEntity.notFound().build(); // retorna o código 404
    }

}
