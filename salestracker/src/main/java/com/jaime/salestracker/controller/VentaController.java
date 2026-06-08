package com.jaime.salestracker.controller;

import com.jaime.salestracker.dto.VendedorKpiDTO;
import com.jaime.salestracker.model.Venta;
import com.jaime.salestracker.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor

public class VentaController {

    private final VentaService ventaService;

    // GET /api/ventas devuelve todas las ventas
    @GetMapping
    public List<Venta> obtenerTodas() {
        return ventaService.obtenerTodas();

    }

    // GET /api/ventas/vendedor/2 devuelve todas las ventas de un vendedor concreto
    @GetMapping("/vendedor/{vendedorId}")
    public List<Venta> obtenerPorVendedor(@PathVariable Long vendedorId) {
        return ventaService.obtenerPorVendedor(vendedorId);
    }

    // POST /api/ventas/vendedor/2 registra una venta para un vendedor concreto
    @PostMapping("/vendedor/{vendedorId}")
    public Venta registrar(@PathVariable Long vendedorId, @RequestBody Venta venta) {
        return ventaService.registrar(vendedorId, venta);
    }

    // GET /api/ventas/kpis/1 devuelve los kPIS de un vendedor concreto
    @GetMapping("/kpis/{vendedorId}")
    public VendedorKpiDTO obtenVendedorKpis(@PathVariable Long vendedorId) {
        return ventaService.calcularKpis(vendedorId);
    }

}
