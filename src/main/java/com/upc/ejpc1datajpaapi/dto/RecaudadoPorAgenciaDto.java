package com.upc.ejpc1datajpaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecaudadoPorAgenciaDto {
    private String nombre;
    private Double total_recaudado;
}
