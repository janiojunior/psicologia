package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;

@Entity
public class PacoteConsulta extends Consulta {
    private Integer quantidade;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
