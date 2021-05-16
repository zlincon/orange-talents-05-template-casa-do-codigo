package br.com.zupacademy.lincon.casadocodigo.controllers;

import br.com.zupacademy.lincon.casadocodigo.dtos.AutorDTO;
import br.com.zupacademy.lincon.casadocodigo.entities.Autor;
import br.com.zupacademy.lincon.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/autors")
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
        Autor autor1 = autorRepository.save(autor);
        return ResponseEntity.ok(autor1.toDTO());
    }
}
