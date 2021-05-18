package br.com.zupacademy.lincon.casadocodigo.dtos;

public class OutputLivroDTO {

    private Long id;
    private String titulo;

    public OutputLivroDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
