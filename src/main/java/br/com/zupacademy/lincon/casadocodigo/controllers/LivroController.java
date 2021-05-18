package br.com.zupacademy.lincon.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.dtos.LivroDTO;
import br.com.zupacademy.lincon.casadocodigo.entities.Livro;

@RestController
@RequestMapping("/api/v1/livros")
@Validated
public class LivroController {

	@PersistenceContext
	private EntityManager manager;


//    private final LivroRepository livroRepository;
//
//    @Autowired
//    public LivroController(LivroRepository livroRepository) {
//        this.livroRepository = livroRepository;
//    }

//    @GetMapping
//    public ResponseEntity<List<LivroDTO>> listAll() {
//        List<Livro> livros = livroRepository.findAll();
//        List<LivroDTO> livrosDTO = livros.stream().map(x -> x.toDTO()).collect(Collectors.toList());
//        return ResponseEntity.ok(livrosDTO);
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDTO> save(@RequestBody @Valid LivroDTO livroDTO) {
        Livro livro = livroDTO.toModel(manager);
        manager.persist(livro);
//        livro = livroRepository.save(livro);
        return ResponseEntity.ok(livroDTO);
    }
}
