package com.generation.LaChingona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.LaChingona.model.Categorias;


public interface CategoriasRepository  extends JpaRepository<Categorias, Long>{

	public List<Categorias> findAllByDescricaoContainingAllIgnoreCase(@Param("descricao") String descricao);

	
}
