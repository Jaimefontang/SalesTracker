package com.jaime.salestracker.repository;

import com.jaime.salestracker.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//Le dice a Spring que esta interfaz es la capa de AD.
@Repository

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    // Spring genera la query automaticamente solo con escribir el nombre del metodo
    // Equivaldria a : SELECT * FROM vendedores WHERE email = ?

    Optional<Vendedor> findByEmail(String email);

}
