package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.ConsultaResponseDTO;
import br.unitins.topicos2.ano2024.dto.ConsultaDTO;
import br.unitins.topicos2.ano2024.dto.ConsultaResponseDTO;
import br.unitins.topicos2.ano2024.model.Consulta;
import br.unitins.topicos2.ano2024.model.Consulta;
import br.unitins.topicos2.ano2024.repository.ConsultaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ConsultaServiceImpl implements ConsultaService {

    @Inject
    ConsultaRepository consultaRepository;

    @Inject
    Validator validator;

    @Override
    public List<ConsultaResponseDTO> getAll(int page, int pageSize) {
        List<Consulta> list = consultaRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> ConsultaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }    

    @Override
    public ConsultaResponseDTO findById(Long id) {
        Consulta consulta = consultaRepository.findById(id);
        if (consulta == null)
            throw new NotFoundException("Consulta não encontrado.");
        return ConsultaResponseDTO.valueOf(consulta);
    }

    @Override
    @Transactional
    public ConsultaResponseDTO create(@Valid ConsultaDTO consultaDTO) throws ConstraintViolationException {
        validar(consultaDTO);

        Consulta entity = new Consulta();
        entity.setNome(consultaDTO.nome());
        entity.setPreco(consultaDTO.preco());

        consultaRepository.persist(entity);

        return ConsultaResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public ConsultaResponseDTO update(Long id, ConsultaDTO consultaDTO) throws ConstraintViolationException{
        validar(consultaDTO);
   
        Consulta entity = consultaRepository.findById(id);

        entity.setNome(consultaDTO.nome());
        entity.setPreco(consultaDTO.preco());

        return ConsultaResponseDTO.valueOf(entity);
    }

    private void validar(ConsultaDTO consultaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ConsultaDTO>> violations = validator.validate(consultaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public List<ConsultaResponseDTO> findByNome(String nome) {
        List<Consulta> list = consultaRepository.findByNome(nome).list();
        return list.stream().map(e -> ConsultaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return consultaRepository.count();
    }

}