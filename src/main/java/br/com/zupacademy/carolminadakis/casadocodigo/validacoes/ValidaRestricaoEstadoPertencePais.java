package br.com.zupacademy.carolminadakis.casadocodigo.validacoes;


import br.com.zupacademy.carolminadakis.casadocodigo.cliente.controller.request.ClienteRequest;
import br.com.zupacademy.carolminadakis.casadocodigo.estado.model.Estado;
import br.com.zupacademy.carolminadakis.casadocodigo.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ValidaRestricaoEstadoPertencePais implements Validator {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> classe) {
        return ClienteRequest.class.isAssignableFrom(classe);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        ClienteRequest clienteRequest = (ClienteRequest) target;
        List<Estado> estados = estadoRepository.findByPaisId(clienteRequest.getPaisId());
        if(estados.size()>= 1 && clienteRequest.getEstadoId()== null) {
            errors.rejectValue("estadoId", null, "Este país possui estados, selecione um");

        }
        if(clienteRequest.getEstadoId() != null && estadoNaoPertence(estados, clienteRequest)) {
            errors.rejectValue("estadoId", null, "Este Estado não pertence a este Pais");


        }

    }
    private boolean estadoNaoPertence(List<Estado> estados, ClienteRequest clienteRequest) {

        for (Estado estado : estados) {
            if (clienteRequest.getEstadoId() == estado.getId()) {
                return false;
            }

        }
        return true;
    }
}
