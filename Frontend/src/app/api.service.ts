import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Product } from './product';
import { Category } from './category';
import { Customer } from './customer';
import { Transaction } from './transaction';
import { Place } from './place';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = "http://localhost:8080/api/v1/";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  getProducts (): Observable<Product[]> {
    return this.http.get<Product[]>(apiUrl+"products")
      .pipe(
        tap(products => console.log('Fetch products')),
        catchError(this.handleError('getProducts', []))
      );
  }

  getCategories (): Observable<Category[]> {
    return this.http.get<Category[]>(apiUrl+"categories")
      .pipe(
        tap(products => console.log('Fetch categories')),
        catchError(this.handleError('getCategories', []))
      );
  }

  getCustomers (): Observable<Customer[]> {
    return this.http.get<Customer[]>(apiUrl+"customers")
      .pipe(
        tap(products => console.log('Fetch customers')),
        catchError(this.handleError('getCustomers', []))
      );
  }

  getPlaces (): Observable<Place[]> {
    return this.http.get<Place[]>(apiUrl+"places")
      .pipe(
        tap(products => console.log('Fetch places')),
        catchError(this.handleError('getPlaces', []))
      );
  }

  getTransactions (): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(apiUrl+"transactions")
      .pipe(
        tap(products => console.log('Fetch transactions')),
        catchError(this.handleError('getTransactions', []))
      );
  }

  getProduct(id: number): Observable<Product> {
    const url = `${apiUrl}product/${id}`;
    return this.http.get<Product>(url).pipe(
      tap(_ => console.log(`fetched product id=${id}`)),
      catchError(this.handleError<Product>(`getProduct id=${id}`))
    );
  }

  addProduct (product): Observable<Product> {
    return this.http.post<Product>(apiUrl, product, httpOptions).pipe(
      tap((product: Product) => console.log(`added product w/ id=${product.idProduct}`)),
      catchError(this.handleError<Product>('addProduct'))
    );
  }

  addTransaction (transaction:Transaction, url:string):Observable<Transaction>{
    console.log(transaction)
    
    return this.http.post<Transaction>(apiUrl+"transactions"+url, transaction, httpOptions).pipe(
      tap((transaction: Transaction) => console.log(`added transaction w/ id=${transaction.total}`)),
      catchError(this.handleError<Transaction>('addTransaction'))
    );
  }

  getRoute (url:string):Observable<any>{
    return this.http.post<any>(apiUrl+url, null, httpOptions).pipe(
      tap((transaction: Transaction) => console.log("route")),
      catchError(this.handleError<Transaction>('getRoute'))
    );
  }

  updateProduct (id, product): Observable<any> {
    const url = `${apiUrl}/${id}`;
    return this.http.put(url, product, httpOptions).pipe(
      tap(_ => console.log(`updated product id=${id}`)),
      catchError(this.handleError<any>('updateProduct'))
    );
  }

  deleteProduct (id): Observable<Product> {
    const url = `${apiUrl}product/${id}`;

    return this.http.delete<Product>(url, httpOptions).pipe(
      tap(_ => console.log(`deleted product id=${id}`)),
      catchError(this.handleError<Product>('deleteProduct'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
