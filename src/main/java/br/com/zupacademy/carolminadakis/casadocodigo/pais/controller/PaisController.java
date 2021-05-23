package br.com.zupacademy.carolminadakis.casadocodigo.pais.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.pais.controller.request.PaisRequest;
import br.com.zupacademy.carolminadakis.casadocodigo.pais.model.Pais;
import br.com.zupacademy.carolminadakis.casadocodigo.pais.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
        Pais pais = paisRequest.converter();
        paisRepository.save(pais);

        return ResponseEntity.ok().build();
    }
}
