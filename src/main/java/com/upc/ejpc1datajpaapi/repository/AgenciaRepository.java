package com.upc.ejpc1datajpaapi.repository;

import com.upc.ejpc1datajpaapi.model.Agencia;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    @Query (value="SELECT ag.nombre as nombre, SUM(an.precio) as dinero_recaudado FROM agencia ag LEFT JOIN anuncio an ON an.id_agencia = ag.id WHERE fecha_publicacion = :fecha GROUP BY ag.nombre", nativeQuery = true)
    List<Tuple> recaudadoPorFecha(@Param("fecha") LocalDate fecha);
}
