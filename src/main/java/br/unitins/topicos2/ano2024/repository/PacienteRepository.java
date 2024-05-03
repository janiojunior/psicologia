package br.unitins.topicos2.ano2024.repository;

import br.unitins.topicos2.ano2024.model.Paciente;
import br.unitins.topicos2.ano2024.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PacienteRepository implements PanacheRepository<Paciente> {

    public PanacheQuery<Paciente> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("SELECT p FROM Paciente p WHERE UPPER(p.pessoa.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }

    public PanacheQuery<Paciente> findByUsernameAndSenha(String username, String senha) {
        return find("pessoa.usuario.username = ?1 AND  pessoa.usuario.senha = ?2", username, senha);
    }

}
