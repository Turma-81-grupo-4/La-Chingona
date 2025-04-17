package com.generation.LaChingona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.LaChingona.model.Produtos;
import com.generation.LaChingona.repository.CategoriasRepository;
import com.generation.LaChingona.repository.ProdutosRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/Produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarPorId(@PathVariable Long id) {
        Optional<Produtos> produto = produtosRepository.findById(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Produtos>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(produtosRepository
				.findAllByDescricaoContainingAllIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Produtos> criar(@Valid @RequestBody Produtos produto) {
	    Produtos novoProduto = produtosRepository.save(produto);
	    return ResponseEntity.status(201).body(novoProduto); 
	}
	
	
	@PutMapping
	public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produto) {
	    if (produtosRepository.existsById(produto.getId())) {

	        if (categoriasRepository.existsById(produto.getCategoria().getId())) {
	            return ResponseEntity.status(HttpStatus.OK)
	                                 .body(produtosRepository.save(produto));
	        }

	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!", null);
	    }

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	    }
	
	
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void  delete(@PathVariable Long id) {
		Optional<Produtos> produtos = produtosRepository.findById(id);
		
		if(produtos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		produtosRepository.deleteById(id);
	}
	
}
