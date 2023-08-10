package com.hipermaxi.service;

import com.hipermaxi.dtos.ProductoCreateDTO;
import com.hipermaxi.dtos.ProductoDTO;
import com.hipermaxi.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO>  listarProductos();
    ProductoDTO obtenerProductoPorID(long id);
    ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO);
    ProductoDTO eliminarProducto(long id);

}
