package com.hipermaxi.service;

import com.hipermaxi.dtos.*;
import com.hipermaxi.mappers.ClienteMapper;
import com.hipermaxi.mappers.PedidoDetalleMapper;
import com.hipermaxi.mappers.PedidoMapper;
import com.hipermaxi.mappers.ProductoMapper;
import com.hipermaxi.model.Cliente;
import com.hipermaxi.model.Pedido;
import com.hipermaxi.model.PedidoDetalle;
import com.hipermaxi.model.Producto;
import com.hipermaxi.repository.PedidoDetalleRepository;
import com.hipermaxi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;
    @Override
    public List<PedidoDTO> listarPedidos() {
        List<PedidoDTO> lista=PedidoMapper.instancia.listaPedidoAListaPedidoDTO( pedidoRepository.findAll());
        for (PedidoDTO pedidoDTO : lista) {
            List<PedidoDetalleDTO> pedidoDetalleDTOs = PedidoDetalleMapper.instancia.listaPedidoDetalleAListaPedidoDetalleDTO(
                                                            pedidoDetalleRepository.getPedidoDetalleByPedidoId(pedidoDTO.getId())
                                                        );
            pedidoDTO.setPedidoDetalleDTO(pedidoDetalleDTOs);
        }
        return lista;
    }

    @Override
    public PedidoDTO obtenerPedidoPorID(long id) {
        Optional<Pedido> pedido= pedidoRepository.findById(id);
        PedidoDTO pedidoDTO=null;
        if(pedido.isPresent()){
            pedidoDTO = PedidoMapper.instancia.pedidoAPedidoDTO(pedido.get());
            pedidoDTO.setPedidoDetalleDTO(
              PedidoDetalleMapper.instancia.listaPedidoDetalleAListaPedidoDetalleDTO(pedidoDetalleRepository.getPedidoDetalleByPedidoId(pedido.get().getId()))
            );
        }
        return  pedidoDTO;
    }

    @Override
    @Transactional
    public PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO) {

        Pedido pedido=PedidoMapper.instancia.pedidoCreateDTOAPedido(pedidoCreateDTO);
        Cliente cliente = ClienteMapper.instancia.clienteDTOACliente(pedidoCreateDTO.getClienteDTO());
        pedido.setCliente(cliente);
        Pedido respuestaEntity=pedidoRepository.save(pedido);
/*
        List<PedidoDetalle> detalles = pedidoCreateDTO.getPedidoDetalleDTO().stream()
                .map(pedDetalleDTO -> {
                    PedidoDetalle pd = PedidoDetalleMapper.instancia.pedidoDetalleDTOAPedidoDetalle(pedDetalleDTO);
                    pd.setPedido(respuestaEntity);
                    return pd;
                })
                .collect(Collectors.toList());

        pedidoDetalleRepository.saveAll(detalles);
*/

        for (PedidoDetalleCreateDTO pedDetalleCreateDTO :   pedidoCreateDTO.getPedidoDetalleCreateDTO()  ) {
            PedidoDetalle pd=PedidoDetalleMapper.instancia.pedidoDetalleCreateDTOAPedidoDetalle(pedDetalleCreateDTO);
            Producto producto = ProductoMapper.instancia.productoDTOAProducto(pedDetalleCreateDTO.getProductoDTO());
            pd.setProducto(producto);
            pd.setPedido(respuestaEntity);
            pedidoDetalleRepository.save(pd);
        }

        PedidoDTO respuestaDTO= PedidoMapper.instancia.pedidoAPedidoDTO(pedidoRepository.getById(respuestaEntity.getId()));
        ClienteDTO clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(pedidoRepository.getById(respuestaEntity.getId()).getCliente());
        respuestaDTO.setClienteDTO(clienteDTO);
        respuestaDTO.setPedidoDetalleDTO(
          PedidoDetalleMapper.instancia.listaPedidoDetalleAListaPedidoDetalleDTO(pedidoDetalleRepository.getPedidoDetalleByPedidoId(respuestaEntity.getId()))
        );

        for (PedidoDetalleDTO pedDteDTP:respuestaDTO.getPedidoDetalleDTO()) {
            pedDteDTP.setProductoDTO( ProductoMapper.instancia.productoAProductoDTO(pedidoDetalleRepository.getProductoByPedidoDetalleId(pedDteDTP.getId())) );
        }

        return respuestaDTO;
    }

}
