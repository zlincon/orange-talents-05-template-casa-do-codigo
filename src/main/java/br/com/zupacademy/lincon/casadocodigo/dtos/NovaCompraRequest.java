package br.com.zupacademy.lincon.casadocodigo.dtos;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zupacademy.lincon.casadocodigo.entities.Compra;
import br.com.zupacademy.lincon.casadocodigo.entities.Estado;
import br.com.zupacademy.lincon.casadocodigo.entities.Pais;
import br.com.zupacademy.lincon.casadocodigo.validators.ExistsId;
import br.com.zupacademy.lincon.casadocodigo.validators.UniqueValue;

public class NovaCompraRequest {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Compra.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@UniqueValue(domainClass = Compra.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public NovaCompraRequest(@Email @NotBlank String email,
			@NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getDocumento() {
		return documento;
	}

	@Override
	public String toString() {
		return "NovaCompraRequest [email=" + email + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento
				+ ", cidade=" + cidade + ", idPais=" + idPais + ", idEstado="
				+ idEstado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}



	public boolean documentoValido() {
		Assert.hasLength(documento,
				"você nao deveria validar o documento se ele não tiver sido preenchido");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null)
				|| cnpjValidator.isValid(documento, null);
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}
	
	public boolean temEstado() {
		return Optional.ofNullable(idEstado).isPresent();
	}
	
	public Compra toModel(EntityManager manager) {
		@NotNull
		Pais pais = manager.find(Pais.class, idPais);
		
		Compra compra = new Compra(email, nome, sobrenome, documento, endereco,
				complemento, pais, telefone, cep);
		//1
		if (idEstado != null) {
			compra.setEstado(manager.find(Estado.class, idEstado));
		}
		
		return compra;
	}

}