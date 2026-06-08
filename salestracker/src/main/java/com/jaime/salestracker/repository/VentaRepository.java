package com.jaime.salestracker.repository;

import com.jaime.salestracker.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;

import java.util.List;

@Repository

public interface VentaRepository extends JpaRepository<Venta, Long> {

    // Devuelve todas la ventas de un vendedor en concreto
    // Spring genera automaticamente un SELECT * FROM ventas WHERE vendedor_id = ?

    List<Venta> findByVendedorId(Long vendedorId);

    // Ventas de un vendedor entre dos fechas
    List<Venta> findByVendedorIdAndFechaHoraBetween(
            Long vendedorId,
            LocalDateTime inicio,
            LocalDateTime fin);

    // Todas las ventas entre dos fechas
    List<Venta> findByFechaHoraBetween(
            LocalDateTime inicio,
            LocalDateTime fin);

}
