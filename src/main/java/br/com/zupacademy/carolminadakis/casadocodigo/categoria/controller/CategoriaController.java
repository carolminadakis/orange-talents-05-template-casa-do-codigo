package br.com.zupacademy.carolminadakis.casadocodigo.categoria.controller;

<<<<<<< HEAD
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.controller.request.CategoriaRequest;
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cria(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.converter();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }
=======
public class CategoriaController {
>>>>>>> f9bee3a98bd4d72e11b41d87ac049132d00e5acb
}
