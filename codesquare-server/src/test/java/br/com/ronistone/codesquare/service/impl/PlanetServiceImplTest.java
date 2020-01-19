package br.com.ronistone.codesquare.service.impl;

import br.com.ronistone.codesquare.model.Planet;
import br.com.ronistone.codesquare.repository.PlanetRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

class PlanetServiceImplTest {


    public static final long ID = 666L;

    @Test
    void testUpdateNotFoundPlanet(){

        PlanetServiceImpl planetService = mountScenarioUpdateNotFoundPlanet();

        Optional<Planet> response = planetService.update(ID, new Planet());

        assertFalse("Planet must been not found", response.isPresent());

    }

    @Test
    void testUpdateFoundPlanet(){

        PlanetServiceImpl planetService = mountScenarioUpdateFoundPlanet();

        Optional<Planet> response = planetService.update(ID, new Planet());

        assertTrue("Planet must been found", response.isPresent());

    }

    @Test
    void testDeleteNotFoundPlanet(){

        PlanetServiceImpl planetService = mountScenarioDeleteNotFoundPlanet();

        boolean response = planetService.deleteById(ID);

        assertFalse("Planet must been not found", response);
    }

    @Test
    void testDeleteFoundPlanet(){

        PlanetServiceImpl planetService = mountScenarioDeleteFoundPlanet();

        boolean response = planetService.deleteById(ID);

        assertTrue("Planet must been not found", response);

    }

    private PlanetServiceImpl mountScenarioDeleteFoundPlanet() {
        return mountScenario(Optional.of(new Planet()));
    }

    private PlanetServiceImpl mountScenarioUpdateFoundPlanet() {
        return mountScenario(Optional.of(new Planet()));
    }

    private PlanetServiceImpl mountScenarioUpdateNotFoundPlanet(){
        return mountScenario(Optional.empty());
    }

    private PlanetServiceImpl mountScenarioDeleteNotFoundPlanet(){
        return mountScenario(Optional.empty());
    }

    private PlanetServiceImpl mountScenario(Optional<Planet> planet) {
        PlanetServiceImpl planetService = new PlanetServiceImpl();
        PlanetRepository planetRepository = mock(PlanetRepository.class);
        planetService.setPlanetRepository(planetRepository);

        when(planetRepository.findById(anyLong())).thenReturn(planet);
        when(planetRepository.save(any(Planet.class))).thenReturn(new Planet());
        doNothing().when(planetRepository).deleteById(anyLong());
        return planetService;
    }

}
