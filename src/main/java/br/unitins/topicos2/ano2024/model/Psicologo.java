package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Psicologo extends DefaultEntity {
    private String crp;

    @OneToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", unique = true)
    private Pessoa pessoa;

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
