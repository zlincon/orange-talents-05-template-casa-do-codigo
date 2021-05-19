package br.com.zupacademy.lincon.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.dtos.NovaCompraRequest;
import br.com.zupacademy.lincon.casadocodigo.entities.Compra;
import br.com.zupacademy.lincon.casadocodigo.exceptionhandlers.NegocioException;
import br.com.zupacademy.lincon.casadocodigo.validators.EstadoPertenceAPaisValidator;
import br.com.zupacademy.lincon.casadocodigo.validators.NotNullSePaisPossuiEstados;

@RestController
public class CompraController {
	
	@Autowired
	private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;
	@Autowired
	private NotNullSePaisPossuiEstados notNullSePaisPossuiEstados;
	@PersistenceContext
	private EntityManager manager;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoPertenceAPaisValidator, notNullSePaisPossuiEstados);
	}

	@PostMapping(value = "/api/v1/compras")
	@Transactional
	public String cria(@RequestBody @Valid NovaCompraRequest request) {
		if(!request.documentoValido()) {
			throw new NegocioException("Documento inválido.");
		}
//		if(request.temEstado() && request.getIdEstado() == null) {
//			throw new NegocioException("País selecionado possui estados. Por favor, selecione um estado");
//		}
		Compra novaCompra = request.toModel(manager);
		manager.persist(novaCompra);
		
		return novaCompra.toString();
	}
	
}
