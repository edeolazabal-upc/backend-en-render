package com.upc.ejpc1datajpaapi.service;

import com.upc.ejpc1datajpaapi.dto.AnuncioDto;
import com.upc.ejpc1datajpaapi.dto.TotalRecaudadoDto;
import com.upc.ejpc1datajpaapi.model.Agencia;
import com.upc.ejpc1datajpaapi.model.Anuncio;
import com.upc.ejpc1datajpaapi.repository.AgenciaRepository;
import com.upc.ejpc1datajpaapi.repository.AnuncioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AnuncioService {
    final AnuncioRepository anuncioRepository;
    final AgenciaRepository agenciaRepository;

    public AnuncioService(AnuncioRepository anuncioRepository, AgenciaRepository agenciaRepository) {
        this.anuncioRepository = anuncioRepository;
        this.agenciaRepository = agenciaRepository;
    }
    public AnuncioDto save(AnuncioDto anuncioDto) {
        ModelMapper modelMapper = new ModelMapper();
        Anuncio anuncio = modelMapper.map(anuncioDto, Anuncio.class);
        Agencia agencia = agenciaRepository.findById(anuncioDto.getId_agencia()).orElse(null);
        anuncio.setAgencia(agencia);
        anuncio = anuncioRepository.save(anuncio);
        modelMapper.map(anuncio, anuncioDto);
        anuncioDto.setId_agencia(anuncio.getAgencia().getId());
        return anuncioDto;
    }
    public TotalRecaudadoDto totalRecaudadoDto(LocalDate from, LocalDate to) {
        Double total_recaudado = anuncioRepository.totalDineroRecaudado(from, to);
        // Agregado 2024-09-13
        if (total_recaudado == null) {
           total_recaudado = 0.0;
        }
        TotalRecaudadoDto totalRecaudadoDto = new TotalRecaudadoDto();
        totalRecaudadoDto.setTotalRecaudado(total_recaudado);
        return totalRecaudadoDto;
    }
}
