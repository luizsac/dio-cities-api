package com.github.luizsac.citiesapi.service;

import com.github.luizsac.citiesapi.entity.State;
import com.github.luizsac.citiesapi.repository.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    Logger log = LoggerFactory.getLogger(StateService.class);
    private StateRepository repository;

    public StateService(StateRepository repository) {
        this.repository = repository;
    }

    public List<State> getAllStates() {
        log.info("getAllStates");
        return repository.findAll();
    }

    public Optional getStateById(Long id) {
        log.info("getStateById");
        return repository.findById(id);
    }

}
