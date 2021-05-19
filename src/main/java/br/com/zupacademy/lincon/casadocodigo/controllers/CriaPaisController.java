package br.com.zupacademy.lincon.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.dtos.NovoPaisRequest;
import br.com.zupacademy.lincon.casadocodigo.entities.Pais;

@RestController
public class CriaPaisController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/api/v1/paises")
	@Transactional
	public String criaPais(@RequestBody @Valid NovoPaisRequest request) {
		Pais novoPais = new Pais(request.getNome());
		manager.persist(novoPais);
		return novoPais.toString();
	}

}
