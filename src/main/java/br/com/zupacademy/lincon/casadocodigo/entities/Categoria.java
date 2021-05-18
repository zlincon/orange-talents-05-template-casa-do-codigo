package br.com.zupacademy.lincon.casadocodigo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.lincon.casadocodigo.dtos.CategoriaDTO;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	@NotBlank
	private String nome;

	@Deprecated
	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public CategoriaDTO toDTO() {
		return new CategoriaDTO(nome);
	}
}
