import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlanetComponent } from './planet/planet.component';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PlanetFormComponent } from './planet-form/planet-form.component';
import { PlanetUpdateComponent } from './planet-update/planet-update.component';
import { PlanetCreateComponent } from './planet-create/planet-create.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PlanetComponent,
    PlanetListComponent,
    PlanetFormComponent,
    PlanetUpdateComponent,
    PlanetCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
