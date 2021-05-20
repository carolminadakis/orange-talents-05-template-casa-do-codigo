package br.com.zupacademy.carolminadakis.casadocodigo.livro.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.livro.Livro;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.request.LivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity cria(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.converte(manager);
       manager.persist(livro);

        return ResponseEntity.ok().build();
    }
}
