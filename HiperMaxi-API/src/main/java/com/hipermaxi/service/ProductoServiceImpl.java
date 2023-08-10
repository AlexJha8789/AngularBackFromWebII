package com.hipermaxi.service;

import com.hipermaxi.dtos.ProductoCreateDTO;
import com.hipermaxi.dtos.ProductoDTO;
import com.hipermaxi.dtos.ProductoUpdateDTO;
import com.hipermaxi.mappers.ProductoMapper;
import com.hipermaxi.model.Producto;
import com.hipermaxi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return ProductoMapper.instancia.listaProductoAListaProductoDTO( productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProductoPorID(long id) {
        Optional<Producto> producto= productoRepository.findById(id);
        ProductoDTO productoDTO =null;
        if(producto.isPresent()){
            productoDTO = ProductoMapper.instancia.productoAProductoDTO(producto.get());
        }
        return  productoDTO;
    }

    @Override
    public ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO) {
        Producto producto=ProductoMapper.instancia.productoCreateDTOAProducto(productoCreateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        ProductoDTO respuestaDTO= ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO) {

        Producto producto=ProductoMapper.instancia.productoUpdateDTOAProducto(productoUpdateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        ProductoDTO respuestaDTO= ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProductoDTO eliminarProducto(long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            ProductoDTO productoDTO = ProductoMapper.instancia.productoAProductoDTO(productoOptional.get());
            productoRepository.delete(productoOptional.get());
            return productoDTO;
        } else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
