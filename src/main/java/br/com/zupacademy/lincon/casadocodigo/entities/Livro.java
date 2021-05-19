package br.com.zupacademy.lincon.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zupacademy.lincon.casadocodigo.dtos.OutputLivroDTO;

@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String titulo;
	@Column(nullable = false, length = 500)
	private String resumo;
	private String sumario;
	@Column(nullable = false)
	private BigDecimal preco;
	@Column(nullable = false)
	private Integer numeroPaginas;
	@Column(nullable = false)
	private String isbn;
	private LocalDate dataPublicacao;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Autor autor;

	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Max(500) String resumo, String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, @NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public OutputLivroDTO toOutputLivrosDTO() {
		return new OutputLivroDTO(id, titulo);
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

	public Autor getAutor() {
		return autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

}
