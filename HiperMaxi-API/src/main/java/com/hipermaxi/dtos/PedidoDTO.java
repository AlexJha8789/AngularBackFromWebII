package com.hipermaxi.dtos;

import com.hipermaxi.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {

    private Long id;
    private Date fechaPedido;
    private ClienteDTO clienteDTO;
    private List<PedidoDetalleDTO> pedidoDetalleDTO;
}
