package br.com.ronistone.codesquare.controller;

import br.com.ronistone.codesquare.exceptions.PlanetNotFound;
import br.com.ronistone.codesquare.model.Planet;
import br.com.ronistone.codesquare.service.PlanetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping( value = "/api/planet" )
public class PlanetController {

    private final static Logger LOGGER = LogManager.getLogger(PlanetController.class);

    @Autowired
    private PlanetService planetService;

    @GetMapping
    public ResponseEntity findAllPlanetById(){
        try {
            List<Planet> planet = planetService.findAll();
            return ResponseEntity.ok(planet);
        } catch (Exception e) {
            LOGGER.error("Error on findAllPlanetById", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping( value = "/{id}" )
    public ResponseEntity findPlanetById(@PathVariable Long id) {
        try {
            Optional<Planet> planet = planetService.findById(id);
            if (planet.isPresent()) {
                return ResponseEntity.ok(planet);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOGGER.error("Error on findPlanetById: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity createPlanet(@RequestBody Planet planet) {
        try {
            Planet planetSaved = planetService.save(planet).orElseThrow(RuntimeException::new);
            return ResponseEntity.created(URI.create("/api/planet/" + planetSaved.getId())).body(planetSaved);
        } catch (Exception e) {
            LOGGER.error("Error on createPlanet: " + planet, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping( value = "/{id}" )
    public ResponseEntity updatePlanet(@PathVariable Long id, @RequestBody Planet planet) {
        try {
            Planet planetSaved = planetService.update(id, planet).orElseThrow( () -> new PlanetNotFound() );
            return ResponseEntity.created(URI.create("/api/planet/" + planetSaved.getId())).body(planetSaved);
        } catch (PlanetNotFound e){
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            LOGGER.error("Error on updatePlanet["+ id +"]: " + planet, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping( value = "/{id}" )
    public ResponseEntity deletePlanet(@PathVariable Long id){
        try {
            LOGGER.info("Deleting planet: "+ id);
            if (planetService.deleteById(id)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            LOGGER.error("Error on deletePlanet["+ id +"]: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
