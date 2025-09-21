import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {Product} from '../product-model';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private rootUrl = "http://localhost:8080";

  private productsList$ = new BehaviorSubject<Product[]>([]);

  constructor(private httpClient: HttpClient) {}

  public fetchAllProducts(): Observable<Product[]> {
    const response = this.httpClient.get<Product[]>(`${this.rootUrl}/products/`);
    response.subscribe(data => this.productsList$.next(data));
    return response;
  }

  public getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.rootUrl}/products/${id}`);
  }

  public addNewProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${this.rootUrl}/products/`, product);
  }

  public updateProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${this.rootUrl}/products/${product.id}`, product);
  }

  public deleteProduct(id: number): Observable<any> {
    return this.httpClient.delete(`${this.rootUrl}/products/${id}`);
  }

  public getProductsList(): Observable<Product[]> {
    return this.productsList$.asObservable();
  }

}
