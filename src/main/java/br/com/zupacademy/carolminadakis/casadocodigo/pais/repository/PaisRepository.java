package br.com.zupacademy.carolminadakis.casadocodigo.pais.repository;

import br.com.zupacademy.carolminadakis.casadocodigo.estado.model.Estado;
import br.com.zupacademy.carolminadakis.casadocodigo.pais.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    @Query("SELECT e FROM Estado e, Pais p WHERE e.nome = :nome AND p.id = :idPais "
            + "AND e.pais = p " )
    List<Estado> findByNomePais(String nome, Long idPais);
}
