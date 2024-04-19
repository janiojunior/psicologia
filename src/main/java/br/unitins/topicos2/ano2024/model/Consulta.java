package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta extends DefaultEntity {
    private String nome;
    private Double preco;
    //private Psicologo psicologo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // public Psicologo getPsicologo() {
    //     return psicologo;
    // }

    // public void setPsicologo(Psicologo psicologo) {
    //     this.psicologo = psicologo;
    // }

}
