package br.com.zupacademy.carolminadakis.casadocodigo.autor.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.form.AutorForm;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorForm> cadastro(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converter(autorForm);
        autorRepository.save(autor);

        return ResponseEntity.ok().build();

    }
}
