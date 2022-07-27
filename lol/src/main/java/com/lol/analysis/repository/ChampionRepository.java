package com.lol.analysis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lol.analysis.dto.ChampionDto;

public interface ChampionRepository extends CrudRepository<ChampionDto, String>{
	public Iterable<ChampionDto> findAllByOrderByNameAsc();

	public ChampionDto findByCode(int code);
	
	public Page<ChampionDto> findAll(Pageable pageable);

	public ChampionDto findByName(String name);
	
}
