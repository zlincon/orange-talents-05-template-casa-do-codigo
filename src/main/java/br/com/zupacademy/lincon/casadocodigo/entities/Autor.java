package br.com.zupacademy.lincon.casadocodigo.entities;

import br.com.zupacademy.lincon.casadocodigo.dtos.AutorDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "autors")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private Instant timestamp;

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.timestamp = timestamp;
    }

    public Autor(AutorDTO autorDTO) {
        this.nome = autorDTO.getNome();
        this.email = autorDTO.getEmail();
        this.descricao = autorDTO.getDescricao();
        this.timestamp = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
