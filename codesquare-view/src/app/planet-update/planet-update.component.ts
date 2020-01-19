import { Component, OnInit, Input } from '@angular/core';
import { Planet } from '../model/planet';
import { PlanetService } from '../services/planet.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-planet-update',
  templateUrl: './planet-update.component.html',
  styleUrls: ['./planet-update.component.css']
})
export class PlanetUpdateComponent implements OnInit {

  @Input() planet: any;
  @Input() buttonText: String = "Atualizar";
  public id: String;

  constructor(
    private planetService: PlanetService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.planetService.findById(this.id).subscribe((data: {}) => {
      this.planet = data;
    }, (err) => {
      console.error(err);
      this.router.navigate(['/planets']);
    })
  }

  updatePlanet(planet: Planet) {
    console.log("Updating new Planet" + planet);
    this.planetService.updatePlanet(planet, this.id).subscribe();
    this.router.navigate(['/planets']);
  }
}
