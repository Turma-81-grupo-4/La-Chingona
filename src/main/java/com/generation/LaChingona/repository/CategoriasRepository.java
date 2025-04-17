package com.generation.LaChingona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.LaChingona.model.Categorias;
import com.generation.LaChingona.model.Produtos;

public interface CategoriasRepository  extends JpaRepository<Categorias, Long>{

}
