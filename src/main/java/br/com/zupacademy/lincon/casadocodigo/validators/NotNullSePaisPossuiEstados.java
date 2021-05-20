package br.com.zupacademy.lincon.casadocodigo.validators;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.lincon.casadocodigo.dtos.NovaCompraRequest;

@Component
public class NotNullSePaisPossuiEstados implements Validator {

	private EntityManager manager;

	@Autowired
	public NotNullSePaisPossuiEstados(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovaCompraRequest request = (NovaCompraRequest) target;

		if (!request.temEstado()) {

			var estado = manager.createQuery("select e from Estado e where e.pais.id = :value")
					.setParameter("value", request.getIdPais()).getResultList();

			if (!estado.isEmpty()) {
				errors.rejectValue("idEstado", null, "O país selecionado tem estados. Por favor, selecione um estado.");
			}
		}

	}

}
