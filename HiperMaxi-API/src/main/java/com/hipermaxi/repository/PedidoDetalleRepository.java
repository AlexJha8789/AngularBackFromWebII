package com.hipermaxi.repository;

import com.hipermaxi.model.PedidoDetalle;
import com.hipermaxi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle,Long> {
    public List<PedidoDetalle> getPedidoDetalleByPedidoId(Long pedido_id);

    @Query(value =" SELECT  p.id, p.descripcion, p.precio, p.stock  FROM tb_producto p inner join tb_pedido_detalle pd on p.id=pd.id_producto where pd.id=:idpedidoDetalle " ,nativeQuery = true)
    public Producto getProductoByPedidoDetalleId(@Param("idpedidoDetalle") Long idpedidoDetalle);

}
