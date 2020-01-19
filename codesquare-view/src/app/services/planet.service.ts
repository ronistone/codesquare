import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Planet } from '../model/planet';


@Injectable({
    providedIn: 'root'
})
export class PlanetService {
    
    apiUrl : string;
    show = false;
    
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    }
    
    constructor(private http: HttpClient) {
        this.apiUrl = environment.apiUrl;
    }
    
    public createPlanet(planet: Planet) {
        return this.http.post(this.apiUrl + '/planet/', planet)
        .pipe( retry(1), catchError(this.handleError))
    }
    
    public findById(id: String) {
        return this.http.get<Planet>(this.apiUrl + '/planet/' + id)
            .pipe( retry(1), catchError(this.handleError))
    }

    public fetchAll(): Observable<Planet> {
        return this.http.get<Planet>(this.apiUrl + '/planet')
        .pipe( retry(1), catchError(this.handleError))
    }
    
    public updatePlanet(planet: Planet, id: String) {
        return this.http.put(this.apiUrl + '/planet/' + id, planet)
        .pipe( retry(1), catchError(this.handleError))
    }

    public deletePlanet(id: number) {
        console.log('delete on ' + this.apiUrl + '/planet/' + id);
        return this.http.delete(this.apiUrl + '/planet/' + id)
                .pipe( retry(1), catchError(this.handleError))
    }

    handleError(error) {
        let errorMessage : string;
        if(error.error instanceof ErrorEvent){
            errorMessage = error.error.message;
        } else {
            errorMessage = `Error Status: ${error.status}\nMessage: ${error.message}`;
        }
        // window.alert(errorMessage);
        return throwError(errorMessage);
    }
}