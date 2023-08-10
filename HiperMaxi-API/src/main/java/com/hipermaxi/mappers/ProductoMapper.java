package com.hipermaxi.mappers;

import com.hipermaxi.dtos.ProductoCreateDTO;
import com.hipermaxi.dtos.ProductoDTO;
import com.hipermaxi.dtos.ProductoUpdateDTO;
import com.hipermaxi.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {

    ProductoMapper instancia= Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoAProductoDTO(Producto producto);
    Producto productoDTOAProducto(ProductoDTO productoDTO);
    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);
    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);
    List<ProductoDTO> listaProductoAListaProductoDTO (List<Producto> listaProducto);


}
