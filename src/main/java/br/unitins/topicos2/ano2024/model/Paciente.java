package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Paciente extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade naturalidade;

    @OneToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", unique = true)
    private Pessoa pessoa;

    public Cidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Cidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
