import { Component, OnInit } from '@angular/core';
import { PlanetService } from '../services/planet.service';

@Component({
  selector: 'app-planet-list',
  templateUrl: './planet-list.component.html',
  styleUrls: ['./planet-list.component.css']
})
export class PlanetListComponent implements OnInit {

  constructor( private planetService: PlanetService ) { }

  planets: any = [];

  ngOnInit() {

    this.planetService.fetchAll().subscribe((data: {}) => {
        this.planets = data;
    })

  }

  public deletePlanet(id: number){
    try{
      this.planetService.deletePlanet(id).subscribe();
      this.planets = this.planets.filter( (p) => p.id != id );
    } catch(e){
      console.error("Falha ao delete planete: " + id);
      console.error(e);
    }
  }

}
