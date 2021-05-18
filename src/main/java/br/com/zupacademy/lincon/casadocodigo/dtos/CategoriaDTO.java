package br.com.zupacademy.lincon.casadocodigo.dtos;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lincon.casadocodigo.entities.Categoria;

public class CategoriaDTO {
	@NotBlank
	private String nome;

	@Deprecated
	public CategoriaDTO() {
	}

	public CategoriaDTO(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}

	public String getNome() {
		return nome;
	}
}
