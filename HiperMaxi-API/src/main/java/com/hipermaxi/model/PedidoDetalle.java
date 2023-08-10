package com.hipermaxi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tb_pedidoDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name="id_producto")
    private Producto producto;

    @Column(nullable = false)
    private Long cantidad;

    @Column(nullable = false)
    private BigDecimal preciovta;

    @Column(nullable = false)
    private BigDecimal importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pedido")
    private Pedido pedido;

}
