package com.hipermaxi.dtos;

import com.hipermaxi.model.Cliente;
import com.hipermaxi.model.Pedido;
import com.hipermaxi.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDetalleDTO {

    private Long id;
    private ProductoDTO productoDTO;
    private Long cantidad;
    private BigDecimal preciovta;
    private BigDecimal importe;

}
