package br.com.zupacademy.lincon.casadocodigo.dtos;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.lincon.casadocodigo.entities.Estado;
import br.com.zupacademy.lincon.casadocodigo.entities.Pais;
import br.com.zupacademy.lincon.casadocodigo.validators.ExistsId;
import br.com.zupacademy.lincon.casadocodigo.validators.UniqueValue;

public class NovoEstadoRequest {

	@NotBlank
	@UniqueValue(domainClass = Estado.class,fieldName = "nome")
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	@Override
	public String toString() {
		return "NovoEstadoRequest [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public Estado toModel(EntityManager manager) {
		return new Estado(nome, manager.find(Pais.class, idPais));
	}

}
