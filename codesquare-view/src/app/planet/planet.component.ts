import { Component, OnInit, Input } from '@angular/core';
import { Planet } from '../model/planet';
import { PlanetListComponent } from '../planet-list/planet-list.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planet',
  templateUrl: './planet.component.html',
  styleUrls: ['./planet.component.css']
})
export class PlanetComponent implements OnInit {

  @Input() planet: Planet;

  constructor( 
    private planetList: PlanetListComponent, 
    private router: Router
  ) { }
  
  ngOnInit() {
  }

  public editPlanet(){
    this.router.navigate(['/planet/' + this.planet.id]);
  }

  public deletePlanet() {
    console.log("deleting " + this.planet.id);
    this.planetList.deletePlanet(this.planet.id);
  }

}
