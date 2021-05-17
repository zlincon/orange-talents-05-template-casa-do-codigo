package br.com.zupacademy.lincon.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.entities.Categoria;
import br.com.zupacademy.lincon.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

	private final CategoriaRepository categoriaRepository;
		
	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@GetMapping ResponseEntity<java.util.List<Categoria>> List() {
		java.util.List<Categoria> categorias = categoriaRepository.findAll();
		return ResponseEntity.ok(categorias);
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody @Valid Categoria categoria) {
		System.out.println("ok");
//		Categoria categoria = categoriaDTO.toModel();
		categoria = categoriaRepository.save(categoria);
//		categoriaDTO = categoria.toDTO();
		return ResponseEntity.ok(categoria);
	}
	
}
