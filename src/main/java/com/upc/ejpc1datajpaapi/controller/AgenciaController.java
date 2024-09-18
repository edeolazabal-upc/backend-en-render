package com.upc.ejpc1datajpaapi.controller;

import com.upc.ejpc1datajpaapi.dto.AgenciaDto;
import com.upc.ejpc1datajpaapi.dto.RecaudadoPorAgenciaDto;
import com.upc.ejpc1datajpaapi.model.Agencia;
import com.upc.ejpc1datajpaapi.service.AgenciaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/agencia")
public class AgenciaController {
    final AgenciaService agenciaService;

    public AgenciaController(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }
    @PostMapping
    public ResponseEntity<AgenciaDto> create(@RequestBody AgenciaDto agenciaDto) {
        return new ResponseEntity<>(agenciaService.save(agenciaDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RecaudadoPorAgenciaDto>> ListaRecaudadoPorAgencia(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha
            ) {
        return ResponseEntity.ok(agenciaService.recaudadoPorAgencia(fecha));
    }
}
