package com.jaime.salestracker.controller;

import com.jaime.salestracker.model.Vendedor;
import com.jaime.salestracker.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Le dice a Spring que esta clase recibe peticiones HTTP
// y devuelve JSON
@RestController
// Define la ruta base de todos los endspoints de esta clase /api/vendedores
@RequestMapping("api/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    // Spring inyecta directamente el Service
    private final VendedorService vendedorService;

    // GET /api/vendedores Devuelve todos los vendedores
    @GetMapping
    public List<Vendedor> obtenerTodos() {
        return vendedorService.obtenerTodos();
    }

    // GET /api/vendedores/1 devuelve un vendedor por su id
    // @PathVariable extrare el {id} de la URL

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> obtenerPorId(@PathVariable Long id) {
        return vendedorService.obtenerPorId(id)

                .map(ResponseEntity::ok)

                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/vendedores Crea un vendedor nuevo
    // @Requestbode convierte el JSON que llega a la peticion de un obj Vendedor.
    @PostMapping
    public Vendedor crear(@RequestBody Vendedor vendedor) {
        return vendedorService.guardar(vendedor);
    }

    // PUT /api/vendedores/1 actualiza el vendedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> actualizar(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return vendedorService.obtenerPorId(id)
                .map(v -> {
                    vendedor.setId(id);
                    return ResponseEntity.ok(vendedorService.guardar(vendedor));
                })

                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/vendedores/1 desactiva un vendedor.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        vendedorService.desactivar(id);

        return ResponseEntity.noContent().build();
    }

}
