package br.com.zupacademy.lincon.casadocodigo.dtos;

import br.com.zupacademy.lincon.casadocodigo.entities.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

public class AutorDTO {
    @NotBlank()
    private String nome;
    @NotBlank
    @Email
    private String email;
    @Size(max = 400)
    private String descricao;
    private Instant timestamp;

    public AutorDTO(@NotBlank String nome,
                    @NotBlank@Email String email,
                    @Size(max = 400) String descricao, Instant timestamp) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.timestamp = timestamp;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
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
