package com.github.luizsac.citiesapi.resources;

import com.github.luizsac.citiesapi.entity.State;
import com.github.luizsac.citiesapi.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger log = LoggerFactory.getLogger(StateResource.class);
    private StateService service;

    public StateResource(StateService service) {
        this.service = service;
    }

    @GetMapping
    public List<State> getStates() {
        log.info("getStates");
        return service.getAllStates();
    }

    @GetMapping("/{id}")
    public ResponseEntity getState(@PathVariable Long id) {
        log.info("getState");
        Optional stateOptional = service.getStateById(id);
        if (stateOptional.isPresent()) {
            return ResponseEntity.ok().body(stateOptional.get());
        }
        return ResponseEntity.notFound().build();

    }

}
