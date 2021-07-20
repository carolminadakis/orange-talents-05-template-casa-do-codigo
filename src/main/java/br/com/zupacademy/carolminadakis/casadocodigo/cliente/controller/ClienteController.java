package br.com.zupacademy.carolminadakis.casadocodigo.cliente.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.cliente.controller.request.ClienteRequest;
import br.com.zupacademy.carolminadakis.casadocodigo.cliente.model.Cliente;
import br.com.zupacademy.carolminadakis.casadocodigo.cliente.repository.ClienteRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.estado.repository.EstadoRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.pais.repository.PaisRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.validacoes.ValidaRestricaoEstadoPertencePais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ValidaRestricaoEstadoPertencePais validaRestricaoEstadoPertencePais;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaRestricaoEstadoPertencePais);
    }

    @PostMapping
    @Transactional
    public String salvar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.converter(paisRepository, estadoRepository);
       clienteRepository.save(cliente);

        return cliente.toString();
    }
}
