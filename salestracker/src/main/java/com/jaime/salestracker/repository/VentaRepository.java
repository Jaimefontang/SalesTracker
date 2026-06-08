package com.jaime.salestracker.repository;

import com.jaime.salestracker.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface VentaRepository extends JpaRepository<Venta, Long> {

    // Devuelve todas la ventas de un vendedor en concreto
    // Spring genera automaticamente un SELECT * FROM ventas WHERE vendedor_id = ?

    List<Venta> findByVendedorId(Long vendedorId);

}
