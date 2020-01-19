package br.com.ronistone.codesquare.service.impl;

import br.com.ronistone.codesquare.model.Planet;
import br.com.ronistone.codesquare.repository.PlanetRepository;
import br.com.ronistone.codesquare.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PlanetServiceImpl implements PlanetService {


    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public List<Planet> findAll(){
        return (List<Planet>) planetRepository.findAll();
    }

    @Override
    public Optional<Planet> findById(Long id) {
        return planetRepository.findById(id);
    }

    @Override
    public Optional<Planet> save(Planet planet) {
        return Optional.of(planetRepository.save(planet));
    }

    @Override
    public Optional<Planet> update(Long id, Planet planet) {
        boolean found = planetRepository.findById(id).isPresent();

        if(found){
            planet.setId(id);
            return Optional.of(planetRepository.save(planet));
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional planet = planetRepository.findById(id);
        if(planet.isPresent()) {
            planetRepository.deleteById(id);
            return true;
        }
        return false;
    }

    protected void setPlanetRepository(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }
}
