package com.hipermaxi.service;

import com.hipermaxi.dtos.PedidoCreateDTO;
import com.hipermaxi.dtos.PedidoDTO;

import java.util.List;

public interface PedidoService {

    List<PedidoDTO>  listarPedidos();
    PedidoDTO obtenerPedidoPorID(long id);
    PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO);
}


