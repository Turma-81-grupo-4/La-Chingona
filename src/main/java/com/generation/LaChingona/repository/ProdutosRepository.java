package com.generation.LaChingona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.LaChingona.model.Produtos;



public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	public List<Produtos> findAllByDescricaoContainingAllIgnoreCase(@Param("descricao") String descricao);
	

}


