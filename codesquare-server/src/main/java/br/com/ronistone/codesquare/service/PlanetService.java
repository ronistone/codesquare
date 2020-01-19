package br.com.ronistone.codesquare.service;

import br.com.ronistone.codesquare.model.Planet;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PlanetService {

    List<Planet> findAll();

    @Transactional(readOnly = true)
    Optional<Planet> findById(Long id);

    @Transactional
    Optional<Planet> save(Planet planet);

    @Transactional
    Optional<Planet> update(Long id, Planet planet);

    @Transactional
    boolean deleteById(Long id);
}
