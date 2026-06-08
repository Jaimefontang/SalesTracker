package com.jaime.salestracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//import lombok.AllArgsConstructor genera automaticamente un constructor para todos los campos
@Data
@AllArgsConstructor
public class VendedorKpiDTO {

    private Long vendedorId;
    private String nombre;
    private Double totalFacturado;
    private Integer numeroVentas;
    private Double ticketMedio;

}
