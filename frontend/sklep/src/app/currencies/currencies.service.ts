import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CurrenciesRequest} from './currencies.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrenciesService {

  constructor(private http: HttpClient) {}

  private rootUrl = "http://localhost:8080";

  public getCurrenciesList(): Observable<string[]> {
    return this.http.get<string[]>(`${this.rootUrl}/currency/list`);
  }

  public getExchangeRate(from: string, to: string): Observable<number> {
    return this.http.get<number>(`${this.rootUrl}/currency/exchangeRate?from=${from}&to=${to}`);
  }

  public convert(req: CurrenciesRequest): Observable<number> {
    return this.http.post<number>(`${this.rootUrl}/currency/convert`, req);
  }
}
