package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.ConsultaResponseDTO;
import br.unitins.topicos2.ano2024.model.Consulta;
import br.unitins.topicos2.ano2024.repository.ConsultaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
    public List<ConsultaResponseDTO> findByNome(String nome) {
        List<Consulta> list = consultaRepository.findByNome(nome).list();
        return list.stream().map(e -> ConsultaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return consultaRepository.count();
    }

}