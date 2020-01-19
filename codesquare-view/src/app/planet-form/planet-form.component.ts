import { Component, OnInit, Input } from '@angular/core';
import { Planet } from '../model/planet';
import { NgbDateAdapter, NgbDateNativeAdapter } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-planet-form',
  templateUrl: './planet-form.component.html',
  styleUrls: ['./planet-form.component.css'],
  providers: [{provide: NgbDateAdapter, useClass: NgbDateNativeAdapter}]
})
export class PlanetFormComponent implements OnInit {

  @Input() planet: Planet;
  @Input() buttonText: String;
  @Input() actionFunction: any;

  constructor() { }

  ngOnInit() {
  }

  doAction(){
    console.log("Calling action Function");
    this.actionFunction(this.planet);
  }

}
