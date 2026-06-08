package com.jaime.salestracker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
@Table(name = "ventas")

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    // Importe total de la venta en euros
    private Double importe;

    // Numero de productos
    private Integer items;

    // Fecha y hora de la venta
    private LocalDateTime fechaHora;

    // Relacion con el vendedor que realizo la venta
    // @ManyToOne muchas ventas pueden ser realizadas por un unico vendedor
    // @JoinColumnn define la columna que actua como FK en la tabla ventas
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

}
