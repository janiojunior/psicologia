package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Entity;

@Entity
public class ConsultaAvulsa  extends Consulta {
    private TipoConsulta tipoConsulta;

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    
}
