import { Component, OnInit } from '@angular/core';
import { error } from 'console';
import { Producto } from 'src/app/modelos/Producto';
import { ProductoService } from 'src/app/servicio/producto.service';

@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.css']
})
export class ListarProductoComponent implements OnInit {
  productos?:Producto[];

  constructor(private productoService:ProductoService) { }

  ngOnInit(): void {
    this.productoService.getProductos().subscribe(
      data=>{
        this.productos=data;
        console.log(data);
      },
      error=>{
        console.log(error);
      }
      
    )
  }

}
