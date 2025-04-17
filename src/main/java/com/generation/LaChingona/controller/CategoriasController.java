package com.generation.LaChingona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.LaChingona.model.Categorias;
import com.generation.LaChingona.repository.CategoriasRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping
    public ResponseEntity<List<Categorias>> getAll() {
        return ResponseEntity.ok(categoriasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getById(@PathVariable Long id) {
        return categoriasRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // definir quereies method
    public getBy() {
        return 
    }

    @PostMapping
    public ResponseEntity<Categorias> post(@Valid @RequestyBody Categorias categorias) {
        return ResponseEntity.status(HTTPStatus.CREATED)
                .body(categoriasRepository.save(categorias));
    }

    @PutMapping
    public ResponseEntity<Categorias> put(@Valid @RequestBody Categorias categorias) {
        return 
    }

    public delete() {
        return 
    }
}
