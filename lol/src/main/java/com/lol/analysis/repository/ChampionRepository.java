package com.lol.analysis.repository;


import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.dto.ChampionDto;

public interface ChampionRepository extends CrudRepository<ChampionDto, String>{
	public Iterable<ChampionDto> findAllByOrderByNameAsc();

	public ChampionDto findByCode(int code);
	
}
