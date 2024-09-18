package com.upc.ejpc1datajpaapi.service;

import com.upc.ejpc1datajpaapi.dto.AgenciaDto;
import com.upc.ejpc1datajpaapi.dto.RecaudadoPorAgenciaDto;
import com.upc.ejpc1datajpaapi.model.Agencia;
import com.upc.ejpc1datajpaapi.repository.AgenciaRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgenciaService {
    final AgenciaRepository agenciaRepository;

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }
    public AgenciaDto save(AgenciaDto agenciaDto) {
        ModelMapper modelMapper = new ModelMapper();
        Agencia agencia = modelMapper.map(agenciaDto, Agencia.class);
        agencia = agenciaRepository.save(agencia);
        return modelMapper.map(agencia, AgenciaDto.class);
    }
    public List<RecaudadoPorAgenciaDto> recaudadoPorAgencia(LocalDate fecha) {
        List<Tuple> tuplas = agenciaRepository.recaudadoPorFecha(fecha);
        List<RecaudadoPorAgenciaDto> ListRecaud = new ArrayList<>();
        RecaudadoPorAgenciaDto recaud;
        for (Tuple tuple : tuplas) {
            recaud = new RecaudadoPorAgenciaDto(
                    tuple.get("nombre", String.class),
                    tuple.get("dinero_recaudado", Double.class)
            );
            ListRecaud.add(recaud);
        }
        return ListRecaud;
    }
}
