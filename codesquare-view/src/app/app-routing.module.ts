import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanetComponent } from './planet/planet.component';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PlanetCreateComponent } from './planet-create/planet-create.component';
import { PlanetUpdateComponent } from './planet-update/planet-update.component';


const routes: Routes = [
  { path: '', component: PlanetListComponent },
  { path: 'planets', component: PlanetListComponent },
  { path: 'planet/new', component: PlanetCreateComponent },
  { path: 'planet/:id', component: PlanetUpdateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
