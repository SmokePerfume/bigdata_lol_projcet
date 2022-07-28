package com.lol.analysis.repository;

import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.dto.ChampBottomTierDto;

public interface ChampBottomTierRepository extends CrudRepository<ChampBottomTierDto, String>{

	Iterable<ChampBottomTierDto> findAllByOrderByTierAsc();

}
