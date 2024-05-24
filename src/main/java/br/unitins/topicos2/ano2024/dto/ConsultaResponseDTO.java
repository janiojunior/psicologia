package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.Consulta;

public record ConsultaResponseDTO (
    Long id,
    String nome,
    Double preco,
    String nomeImagem
) {

    public static ConsultaResponseDTO valueOf(Consulta consulta) {
        return new ConsultaResponseDTO(
            consulta.getId(), 
            consulta.getNome(),
            consulta.getPreco(),
            consulta.getNomeImagem()
        );
    }

}