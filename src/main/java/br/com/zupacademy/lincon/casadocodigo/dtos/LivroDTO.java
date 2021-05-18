package br.com.zupacademy.lincon.casadocodigo.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.lincon.casadocodigo.entities.Autor;
import br.com.zupacademy.lincon.casadocodigo.entities.Categoria;
import br.com.zupacademy.lincon.casadocodigo.entities.Livro;
import br.com.zupacademy.lincon.casadocodigo.validators.ExistsId;
import br.com.zupacademy.lincon.casadocodigo.validators.UniqueValue;

public class LivroDTO {
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	private String sumario;
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private Integer numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;
	
	public LivroDTO(@NotBlank String titulo, @NotBlank @Max(500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numeroPaginas, @NotBlank String isbn, Long idCategoria, Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	
	public Livro toModel(EntityManager manager) {
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	
	
}
