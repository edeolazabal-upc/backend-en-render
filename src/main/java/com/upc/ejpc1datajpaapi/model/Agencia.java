package com.upc.ejpc1datajpaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Agencia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;

    @OneToMany(mappedBy = "agencia", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Anuncio> anuncios;

    public Agencia(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
