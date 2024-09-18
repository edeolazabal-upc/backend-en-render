package com.upc.ejpc1datajpaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioDto {
    private Long id;
    private String nombre;
    private double precio;
    private String publicObjetivo;
    private Integer duracion;
    private LocalDate fechaPublicacion;
    private Long id_agencia;
}
