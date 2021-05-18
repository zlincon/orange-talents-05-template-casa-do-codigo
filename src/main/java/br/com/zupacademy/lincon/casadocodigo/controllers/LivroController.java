package br.com.zupacademy.lincon.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.zupacademy.lincon.casadocodigo.dtos.OutputLivroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.lincon.casadocodigo.dtos.LivroDTO;
import br.com.zupacademy.lincon.casadocodigo.entities.Livro;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/livros")
@Validated
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

    @GetMapping
    public ResponseEntity<List<OutputLivroDTO>> listAll() {
        List<Livro> livros = manager.createQuery("from Livro").getResultList();
        List<OutputLivroDTO> outputLivrosDTO = livros.stream().map(x -> x.toOutputLivrosDTO()).collect(Collectors.toList());
        return ResponseEntity.ok(outputLivrosDTO);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDTO> save(@RequestBody @Valid LivroDTO livroDTO) {
        Livro livro = livroDTO.toModel(manager);
        manager.persist(livro);
//        livro = livroRepository.save(livro);
        return ResponseEntity.ok(livroDTO);
    }
}
