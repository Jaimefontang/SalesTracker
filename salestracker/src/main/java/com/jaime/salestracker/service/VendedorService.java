package com.jaime.salestracker.service;

import com.jaime.salestracker.model.Vendedor;
import com.jaime.salestracker.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Le dice a Spring que esta clase es la capa de lógica.
@Service
// Esto es Lombok, genera automaticamente el constructor.
@RequiredArgsConstructor

public class VendedorService {
    // Spring inyecta el Repository gracias a @RequiredArgsConstructor.
    private final VendedorRepository vendedorRepository;

    // Devuelve todos los vendedores de la BD
    public List<Vendedor> obtenerTodos() {
        return vendedorRepository.findAll();
    }

    // Busca un vendedor por su Id devuelve Optional por que puede que no exista.
    public Optional<Vendedor> obtenerPorId(Long id) {
        return vendedorRepository.findById(id);
    }

    // Desactiva a un vendedor en vez de Borrarlo (softdelete)
    public void desactivar(Long id) {
        vendedorRepository.findById(id).ifPresent(vendedor -> {
            vendedor.setActivo(false);
            vendedorRepository.save(vendedor);
        });

    }

    // Guarda un vendedor nuevo o actualiza uno que ya existe

    public Vendedor guardar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

}
