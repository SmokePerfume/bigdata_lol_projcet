package com.lol.analysis.repository;

import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.dto.ChampMiddleTierDto;

public interface ChampMiddleTierRepository extends CrudRepository<ChampMiddleTierDto, String>{
	
	public Iterable<ChampMiddleTierDto> findAllByOrderByTierAsc();
	
}
