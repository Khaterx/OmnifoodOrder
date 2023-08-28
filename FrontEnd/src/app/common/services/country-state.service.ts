import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Country} from "../model/country";
import {State} from "../model/state";

@Injectable({
  providedIn: 'root'
})
export class CountryStateService {
  baseUrl: string = "http://127.0.0.1:8080/v1/api/";

  constructor(private _http: HttpClient) {
  }

  getAllCountries(): Observable<Country[]> {
    return this._http.get<Country[]>(`${this.baseUrl}getAllCountries`).pipe(
      map(
        response => response
      )
    )
  }

  getAllStates(): Observable<State[]> {
    return this._http.get<State[]>(`${this.baseUrl}getAllStates`).pipe(
      map(
        response => response
      )
    )
  }

  getAllStatesByCountryCode(code: any): Observable<State[]> {
    return this._http.get<State[]>(`${this.baseUrl}getStateByCountryCode?code=${code}`).pipe(
      map(
        response => response
      )
    )
  }
}
