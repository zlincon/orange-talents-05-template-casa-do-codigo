package br.com.zupacademy.lincon.casadocodigo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.dtos.DetalheSiteLivroResponse;
import br.com.zupacademy.lincon.casadocodigo.dtos.LivroDTO;
import br.com.zupacademy.lincon.casadocodigo.dtos.OutputLivroDTO;
import br.com.zupacademy.lincon.casadocodigo.entities.Livro;
import br.com.zupacademy.lincon.casadocodigo.exceptionhandlers.NotFoundException;

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
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalheSiteLivroResponse> detalhe(@PathVariable("id") Long id) {
    	Livro livroBuscado = manager.find(Livro.class, id);
    	if(livroBuscado == null) {
    		throw new NotFoundException("Book not found");
    	}
    	DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
    	return ResponseEntity.ok(detalheSiteLivroResponse);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDTO> save(@RequestBody @Valid LivroDTO livroDTO) {
        Livro livro = livroDTO.toModel(manager);
        manager.persist(livro);
        return ResponseEntity.ok(livroDTO);
    }
}
