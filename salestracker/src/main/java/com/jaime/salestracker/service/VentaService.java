package com.jaime.salestracker.service;

import com.jaime.salestracker.model.Venta;
import com.jaime.salestracker.model.Vendedor;
import com.jaime.salestracker.repository.VentaRepository;
import com.jaime.salestracker.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.jaime.salestracker.dto.VendedorKpiDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;
    private final VendedorRepository vendedorRepository;

    // Devuelve todas las ventas a la BD
    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

    // Devuelve todas las ventas de un vendedor concreto
    public List<Venta> obtenerPorVendedor(Long vendedorId) {
        return ventaRepository.findByVendedorId(vendedorId);
    }

    // Registra una venta nueva vinculada a un vendedor
    // Si el vendedor no eciste lanza una excepcion

    public Venta registrar(Long vendedorId, Venta venta) {
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        venta.setVendedor(vendedor);
        venta.setFechaHora(LocalDateTime.now());

        return ventaRepository.save(venta);
    }

    // Calcular los Kpis de un vendedor concreto
    public VendedorKpiDTO calcularKpis(Long vendedorId) {
        // Busca el vendedor o lanza excepcion si no existe

        Vendedor vendedor = vendedorRepository.findById(vendedorId)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        // Obtiene todas las vendas de ese vendedor
        List<Venta> ventas = ventaRepository.findByVendedorId(vendedorId);

        // Calcula el total facturado sumando todos los importes.
        Double totalFacturado = ventas.stream()
                .mapToDouble(Venta::getImporte)
                .sum();

        // Cuenta el numero de ventas
        Integer numeroVentas = ventas.size();

        // Calcula el ticket medio
        Double ticketMedio = numeroVentas > 0 ? totalFacturado / numeroVentas : 0.0;

        return new VendedorKpiDTO(vendedorId, vendedor.getNombre(), totalFacturado, numeroVentas, ticketMedio);

    }

    // Devuelve el raking de todos los vendedores ordenado por total facturado.
}
