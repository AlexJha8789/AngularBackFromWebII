package com.hipermaxi.repository;

import com.hipermaxi.model.Pedido;
import com.hipermaxi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
