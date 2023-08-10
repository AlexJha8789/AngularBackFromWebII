package com.hipermaxi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteUpdateDTO {

    private Long id;
    private String dni;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Date fechaNacimiento;
    private String email;
}
