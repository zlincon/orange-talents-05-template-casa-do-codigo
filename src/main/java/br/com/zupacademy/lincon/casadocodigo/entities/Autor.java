package br.com.zupacademy.lincon.casadocodigo.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.zupacademy.lincon.casadocodigo.dtos.AutorDTO;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    private String descricao;
    @Column(nullable = false)
    private Instant timestamp = Instant.now();

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorDTO toDTO() {
        return new AutorDTO(this.nome, this.email, this.descricao, this.timestamp);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
    
    
}
