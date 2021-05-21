package br.com.zupacademy.carolminadakis.casadocodigo.autor.repository;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);


}
