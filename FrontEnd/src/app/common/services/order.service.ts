import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Order} from "../model/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl: string = "http://127.0.0.1:8080/v1/api/";

  constructor(private _http: HttpClient) {
  }

  getAllOrders(page: any, size: any): Observable<Order[]> {
    return this._http.get<Order[]>(`${this.baseUrl}getAllOrder?page=${page}&size=${size}`).pipe(
      map(
        response => response
      )
    )
  }

  getAllOrdersByCategoryId(id: string | null, page: any, size: any): Observable<Order[]> {
    return this._http.get<Order[]>(`${this.baseUrl}getOrderByCategoryId?id=${id}&page=${page}&size=${size}`).pipe(
      map(
        response => response
      )
    )
  }

  getOrderByName(name: string | null, page: any, size: any): Observable<Order[]> {
    return this._http.get<Order[]>(`${this.baseUrl}getOrderByName/${name}&${page}&${size}`).pipe(
      map(
        response => response
      )
    )
  }

  getOrderById(id: string | null): Observable<Order> {
    return this._http.get<Order>(`${this.baseUrl}getOrderById/${id}`).pipe(
      map(
        response => response
      )
    )
  }

  getOrderLength(): Observable<number> {
    return this._http.get<number>(`${this.baseUrl}getOrderLength`).pipe(
      map(
        response => response
      )
    )
  }

  getOrderLengthByCategoryId(id: number): Observable<number> {
    return this._http.get<number>(`${this.baseUrl}getOrderLengthByCategoryId?id=${id}`).pipe(
      map(
        response => response
      )
    )
  }

  getOrderLengthByKeyword(keyword: string): Observable<number> {
    return this._http.get<number>(`${this.baseUrl}getOrderLengthByKeyword?keyword=${keyword}`).pipe(
      map(
        response => response
      )
    )
  }
}
