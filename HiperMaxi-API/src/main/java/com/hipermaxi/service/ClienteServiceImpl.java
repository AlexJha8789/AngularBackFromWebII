package com.hipermaxi.service;

import com.hipermaxi.dtos.ClienteCreateDTO;
import com.hipermaxi.dtos.ClienteDTO;
import com.hipermaxi.dtos.ClienteUpdateDTO;
import com.hipermaxi.mappers.ClienteMapper;
import com.hipermaxi.model.Cliente;
import com.hipermaxi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository  clienteRepository;

    @Override
    public List<ClienteDTO> listarClientes() {

        List<Cliente> lista = clienteRepository.findAll();

        for (Cliente cli : lista) {
            System.out.println(" "+ cli.getId().toString() +" --> "+ cli.getFechaNacimiento().toString());
        }

        return ClienteMapper.instancia.listaClienteAListaClienteDTO( clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        Optional<Cliente> producto= clienteRepository.findById(id);
        ClienteDTO clienteDTO=null ;
        if(producto.isPresent()){
            clienteDTO = ClienteMapper.instancia.clienteAClienteDTO(producto.get());
        }
        return  clienteDTO;
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO productoCreateDTO) {
        Cliente producto=ClienteMapper.instancia.clienteCreateDTOACliente(productoCreateDTO);
        Cliente respuestaEntity=clienteRepository.save(producto);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {

        Cliente producto=ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity=clienteRepository.save(producto);
        ClienteDTO respuestaDTO= ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ClienteDTO eliminarCliente(long id) {
        Optional<Cliente> productoOptional= clienteRepository.findById(id);
        if(productoOptional.isPresent()){
            ClienteDTO clienteDTO=ClienteMapper.instancia.clienteAClienteDTO(productoOptional.get());
            clienteRepository.delete(productoOptional.get());
            return clienteDTO;
        }else {
            throw new NoSuchElementException("No se pudo realizar la eliminación para el ID proporcionado");
        }
    }
}
