package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity {
    private String userName;
    private String senha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
