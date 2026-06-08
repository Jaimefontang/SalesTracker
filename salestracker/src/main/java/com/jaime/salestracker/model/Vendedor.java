package com.jaime.salestracker.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

//Entity comunica a Spring que esta clase es una tabla de nuestra BD
@Entity
// Definimos el nombre de la tabla
@Table(name = "vendedores")
// Genera todo el codigo repetitivo de forma automatica.
@Data
public class Vendedor {
    // Marca este campo como la PK de la tabla
    @Id
    // Hace que el id se genere automaticamente de forma incremental.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String nombre;
    private String email;
    private String password;
    private Double horasContrato;
    private String rol;
    private Boolean activo = true;

}
