package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.ConsultaResponseDTO;
import br.unitins.topicos2.ano2024.dto.ConsultaDTO;
import br.unitins.topicos2.ano2024.dto.ConsultaResponseDTO;
import jakarta.validation.Valid;

public interface ConsultaService {

        // recursos basicos
        List<ConsultaResponseDTO> getAll(int page, int pageSize);

        ConsultaResponseDTO findById(Long id);

        ConsultaResponseDTO create(@Valid ConsultaDTO dto);
    
        ConsultaResponseDTO update(Long id, ConsultaDTO dto);
    
        void delete(Long id);

        List<ConsultaResponseDTO> findByNome(String nome);
    
        long count();

}
