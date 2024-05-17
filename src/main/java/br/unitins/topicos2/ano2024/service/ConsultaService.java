package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.ConsultaResponseDTO;
import br.unitins.topicos2.ano2024.dto.EstadoResponseDTO;
import jakarta.validation.Valid;

public interface ConsultaService {

        // recursos basicos
        List<ConsultaResponseDTO> getAll(int page, int pageSize);

        ConsultaResponseDTO findById(Long id);

        List<ConsultaResponseDTO> findByNome(String nome);
    
        long count();

}
