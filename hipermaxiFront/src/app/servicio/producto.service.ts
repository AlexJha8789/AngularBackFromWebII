import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../modelos/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http:HttpClient) { }
  url='http://localhost:8080/api/productos';

  getProductos(){
    return this.http.get<Producto[]>(this.url);
  }
}
