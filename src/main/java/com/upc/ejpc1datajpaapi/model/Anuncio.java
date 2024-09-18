package com.upc.ejpc1datajpaapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private String publicObjetivo;
    private Integer duracion;
    private LocalDate fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_agencia")
    private Agencia agencia;

    public Anuncio(String nombre, double precio, String publicObjetivo, Integer duracion, LocalDate fechaPublicacion, Agencia agencia) {
        this.nombre = nombre;
        this.precio = precio;
        this.publicObjetivo = publicObjetivo;
        this.duracion = duracion;
        this.fechaPublicacion = fechaPublicacion;
        this.agencia = agencia;
    }
}
