package com.upc.ejpc1datajpaapi.controller;

import com.upc.ejpc1datajpaapi.dto.AnuncioDto;
import com.upc.ejpc1datajpaapi.dto.TotalRecaudadoDto;
import com.upc.ejpc1datajpaapi.service.AnuncioService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/anuncio")
public class AnuncioController {
    final AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }
    @PostMapping
    public ResponseEntity<AnuncioDto> creaAnuncio(@RequestBody AnuncioDto anuncioDto) {
        return new ResponseEntity<>(anuncioService.save(anuncioDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<TotalRecaudadoDto> getTotalRecaudado(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return ResponseEntity.ok(anuncioService.totalRecaudadoDto(from, to));
    }
}
