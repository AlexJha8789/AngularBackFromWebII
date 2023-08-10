package com.hipermaxi.controller;


import com.hipermaxi.dtos.ClienteCreateDTO;
import com.hipermaxi.dtos.ClienteDTO;
import com.hipermaxi.dtos.ClienteUpdateDTO;
import com.hipermaxi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteContoller {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("clientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return   new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("clienteId") long clienteId){
        return  new ResponseEntity<> ( clienteService.obtenerClientePorID(clienteId),HttpStatus.OK);
    }

    @PostMapping("clientes")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO){
        return  new ResponseEntity <>( clienteService.registrarCliente(clienteCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("clientes")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteUpdateDTO clienteUpdateDTO){
        return new ResponseEntity<>(clienteService.actualizarCliente(clienteUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public ResponseEntity<ClienteDTO> eliminarCliente(@PathVariable("clienteId") long clienteId) {
        return new ResponseEntity<>( clienteService.eliminarCliente(clienteId),HttpStatus.OK);
    }
}
