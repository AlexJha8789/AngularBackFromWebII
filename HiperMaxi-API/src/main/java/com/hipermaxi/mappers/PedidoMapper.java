package com.hipermaxi.mappers;

import com.hipermaxi.dtos.PedidoCreateDTO;
import com.hipermaxi.dtos.PedidoDTO;
import com.hipermaxi.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper instancia= Mappers.getMapper(PedidoMapper.class);

    PedidoDTO pedidoAPedidoDTO(Pedido pedido);
    List<PedidoDTO> listaPedidoAListaPedidoDTO (List<Pedido> listaPedido);
    Pedido pedidoCreateDTOAPedido(PedidoCreateDTO pedidoCreateDTO);
}
