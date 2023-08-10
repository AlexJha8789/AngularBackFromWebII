package com.hipermaxi.service;

import com.hipermaxi.dtos.*;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO>  listarClientes();
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    ClienteDTO eliminarCliente(long id);

}
