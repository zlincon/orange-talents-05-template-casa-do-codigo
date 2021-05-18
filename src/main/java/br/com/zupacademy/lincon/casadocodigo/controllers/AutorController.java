package br.com.zupacademy.lincon.casadocodigo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lincon.casadocodigo.dtos.AutorDTO;
import br.com.zupacademy.lincon.casadocodigo.entities.Autor;
import br.com.zupacademy.lincon.casadocodigo.exceptionhandlers.NegocioException;
import br.com.zupacademy.lincon.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping("/api/v1/autores")
@Validated
public class AutorController {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> listAll() {
        List<Autor> autors = autorRepository.findAll();
        List<AutorDTO> autorsDTO = autors.stream().map(x -> x.toDTO()).collect(Collectors.toList());
        return ResponseEntity.ok(autorsDTO);
    }

    @PostMapping
    public ResponseEntity<AutorDTO> save(@RequestBody @Valid AutorDTO autorDTO) {
        Autor autor = autorDTO.toModel();
        Optional<Autor> autor1 = autorRepository.findByEmail(autorDTO.getEmail());
        if (autor1.isPresent()){
            throw  new NegocioException("Email já existe em nossa base de dados");
        }
        System.out.println(autor1.toString());
        Autor autor2 = autorRepository.save(autor);
        return ResponseEntity.ok(autor2.toDTO());
    }
}
