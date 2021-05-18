package br.com.zupacademy.lincon.casadocodigo.controllers;

import javax.validation.Valid;

import br.com.zupacademy.lincon.casadocodigo.dtos.CategoriaDTO;
import br.com.zupacademy.lincon.casadocodigo.exceptionhandlers.CategoriaAlreadyExistsException;
import br.com.zupacademy.lincon.casadocodigo.exceptionhandlers.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.entities.Categoria;
import br.com.zupacademy.lincon.casadocodigo.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categorias")
@Validated
public class CategoriaController {

	private final CategoriaRepository categoriaRepository;
		
	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@GetMapping ResponseEntity<List<CategoriaDTO>> List() {
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDTO> categoriasDTO = categorias.stream().map(x -> x.toDTO()).collect(Collectors.toList());
		return ResponseEntity.ok(categoriasDTO);
	}

	@PostMapping
	public ResponseEntity<CategoriaDTO> create(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaDTO.getNome());
        if (categoria.isPresent()){
            throw new NegocioException("Categoria já cadastrada");
        }
        Categoria categoria1 = categoriaDTO.toModel();
		categoria1 = categoriaRepository.save(categoria1);
		categoriaDTO = categoria1.toDTO();
		return ResponseEntity.ok(categoriaDTO);
	}
}
