package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.PacienteDTO;
import br.unitins.topicos2.ano2024.dto.PacienteResponseDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

public interface PacienteService {

        // recursos basicos
        List<PacienteResponseDTO> getAll(int page, int pageSize);

        PacienteResponseDTO findById(Long id);
    
        PacienteResponseDTO create(@Valid PacienteDTO dto);

        PacienteResponseDTO update(Long id, PacienteDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<PacienteResponseDTO> findByNome(String nome);

        UsuarioResponseDTO findByUsernameAndSenha(String username, String senha);
    
        long count();

}
