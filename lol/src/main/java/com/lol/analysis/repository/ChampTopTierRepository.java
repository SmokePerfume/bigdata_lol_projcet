package com.lol.analysis.repository;

import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.dto.ChampTopTierDto;

public interface ChampTopTierRepository extends CrudRepository<ChampTopTierDto,String>{
	
	public Iterable<ChampTopTierDto> findAllByOrderByTierAsc();

	public ChampTopTierDto findByCode(int code);
	
}
