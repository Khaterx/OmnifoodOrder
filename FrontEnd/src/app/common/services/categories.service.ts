import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Category} from "../model/category";

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {
  baseUrl: string = "http://127.0.0.1:8080/v1/api/";

  constructor(private _http: HttpClient) {
  }

  getAllCategories(): Observable<Category[]> {
    return this._http.get<Category[]>(`${this.baseUrl}getAllCategories`).pipe(
      map(
        response => response
      )
    )
  }
}
