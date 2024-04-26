package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.PacienteDTO;
import br.unitins.topicos2.ano2024.dto.PacienteResponseDTO;
import br.unitins.topicos2.ano2024.model.Paciente;
import br.unitins.topicos2.ano2024.repository.PacienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PacienteServiceImpl implements PacienteService {

    @Inject
    PacienteRepository pacienteRepository;

    @Inject
    Validator validator;

    @Override
    public List<PacienteResponseDTO> getAll(int page, int pageSize) {
        List<Paciente> list = pacienteRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> PacienteResponseDTO.valueOf(e)).collect(Collectors.toList());
    }    

    @Override
    public PacienteResponseDTO findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id);
        if (paciente == null)
            throw new NotFoundException("Paciente não encontrado.");
        return PacienteResponseDTO.valueOf(paciente);
    }

    @Override
    @Transactional
    public PacienteResponseDTO create(@Valid PacienteDTO pacienteDTO) throws ConstraintViolationException {
        return null;
    }

    @Override
    @Transactional
    public PacienteResponseDTO update(Long id, PacienteDTO pacienteDTO) throws ConstraintViolationException{
        validar(pacienteDTO);
   
        Paciente entity = pacienteRepository.findById(id);

        return PacienteResponseDTO.valueOf(entity);
    }

    private void validar(PacienteDTO pacienteDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PacienteDTO>> violations = validator.validate(pacienteDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteResponseDTO> findByNome(String nome) {
        List<Paciente> list = pacienteRepository.findByNome(nome).list();
        return list.stream().map(e -> PacienteResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return pacienteRepository.count();
    }

}