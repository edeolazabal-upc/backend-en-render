package com.upc.ejpc1datajpaapi.repository;

import com.upc.ejpc1datajpaapi.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    @Query(value="SELECT SUM(an.precio) as dinero_total FROM anuncio an WHERE an.fecha_publicacion BETWEEN :from AND :to", nativeQuery= true)
    Double totalDineroRecaudado (@Param("from") LocalDate from, @Param("to") LocalDate to);
}
