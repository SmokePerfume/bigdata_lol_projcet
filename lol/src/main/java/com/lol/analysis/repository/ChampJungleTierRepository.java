package com.lol.analysis.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.dto.ChampJungleTierDto;

public interface ChampJungleTierRepository extends CrudRepository<ChampJungleTierDto, String>{

	public Iterable<ChampJungleTierDto> findAllByOrderByTierAsc();
	
	public ChampJungleTierDto findByCode(int code);
	
}
