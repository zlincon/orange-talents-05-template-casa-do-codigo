package br.com.zupacademy.lincon.casadocodigo.dtos;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lincon.casadocodigo.entities.Pais;
import br.com.zupacademy.lincon.casadocodigo.validators.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName =  "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
