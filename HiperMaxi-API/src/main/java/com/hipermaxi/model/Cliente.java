package com.hipermaxi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, nullable = false)
    private String dni;

    @Column(length = 60, nullable = false)
    private String nombres;
    @Column(length = 200, nullable = false)
    private String apePaterno;

    @Column(length = 200, nullable = false)
    private String apeMaterno;

    @Column(name="fechaNacimiento", nullable = false)
    @Temporal(value= TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @Column(length = 200, nullable = false)
    private String email;
}
