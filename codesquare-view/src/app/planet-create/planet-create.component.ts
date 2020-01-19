import { Component, OnInit, Input } from '@angular/core';
import { Planet } from '../model/planet';
import { PlanetService } from '../services/planet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planet-create',
  templateUrl: './planet-create.component.html',
  styleUrls: ['./planet-create.component.css']
})
export class PlanetCreateComponent implements OnInit {

  @Input() planet: Planet = new Planet();
  @Input() buttonText: String = "Criar";

  constructor( 
    private planetService: PlanetService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  createPlanet(planet: Planet){
    console.log("Creating new Planet" + planet);
    this.planetService.createPlanet(planet).subscribe();
    this.router.navigate(['/planets']);
  }
}
