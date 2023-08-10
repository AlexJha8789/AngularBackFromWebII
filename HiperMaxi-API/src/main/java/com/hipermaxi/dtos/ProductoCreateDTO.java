package com.hipermaxi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductoCreateDTO {
    private String descripcion;
    private Integer stock;
    private BigDecimal precio;


}
