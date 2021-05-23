package com.github.luizsac.citiesapi.resources;

import com.github.luizsac.citiesapi.entity.State;
import com.github.luizsac.citiesapi.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    private StateRepository repository;

    public StateResource(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getState(@PathVariable Long id) {
        Optional stateOptional = repository.findById(id);
        if (stateOptional.isPresent()) {
            return ResponseEntity.ok().body(stateOptional.get());
        }
        return ResponseEntity.notFound().build();

    }

}
