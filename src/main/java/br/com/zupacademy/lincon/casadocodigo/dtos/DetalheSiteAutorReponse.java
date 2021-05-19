package br.com.zupacademy.lincon.casadocodigo.dtos;

import br.com.zupacademy.lincon.casadocodigo.entities.Autor;

public class DetalheSiteAutorReponse {

	private String nome;
	private String descricao;

	public DetalheSiteAutorReponse(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
