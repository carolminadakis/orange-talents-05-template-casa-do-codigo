package br.com.zupacademy.carolminadakis.casadocodigo.categoria.repository;

import br.com.zupacademy.carolminadakis.casadocodigo.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
