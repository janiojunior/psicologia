package br.unitins.topicos2.ano2024.repository;

import br.unitins.topicos2.ano2024.model.Psicologo;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PsicologoRepository implements PanacheRepository<Psicologo> {

    public PanacheQuery<Psicologo> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("SELECT p FROM Psicologo p WHERE UPPER(p.pessoa.nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }

}
