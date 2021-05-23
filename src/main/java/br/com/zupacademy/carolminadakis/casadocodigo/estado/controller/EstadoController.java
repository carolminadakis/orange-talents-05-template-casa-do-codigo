package br.com.zupacademy.carolminadakis.casadocodigo.estado.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.estado.controller.request.EstadoRequest;
import br.com.zupacademy.carolminadakis.casadocodigo.estado.model.Estado;
import br.com.zupacademy.carolminadakis.casadocodigo.estado.repository.EstadoRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.pais.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.converter(paisRepository, estadoRepository);
        if (estado == null) {
            return ResponseEntity.notFound().build();
        } estadoRepository.save(estado);
        return ResponseEntity.ok().build();
    }
}
