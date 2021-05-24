package br.com.zupacademy.carolminadakis.casadocodigo.estado.repository;

import br.com.zupacademy.carolminadakis.casadocodigo.estado.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT e FROM Estado e, Pais p WHERE e.nome = :nome AND p.id = :paisId " + "AND e.pais = p " )
    List<Estado> findEstadoPorNomeDoPais(String nome, Long paisId);


    List<Estado> findByPaisId(Long paisId);
}
