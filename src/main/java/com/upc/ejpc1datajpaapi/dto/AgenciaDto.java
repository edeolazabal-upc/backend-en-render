package com.upc.ejpc1datajpaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenciaDto {
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
}
