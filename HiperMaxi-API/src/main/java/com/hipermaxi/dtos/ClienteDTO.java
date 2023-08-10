package com.hipermaxi.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String dni;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private Date fechaNacimiento;
    private String email;
}
