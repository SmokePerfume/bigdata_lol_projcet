package com.lol.analysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.dto.ChampionName;

public interface ChampionNameRepository extends JpaRepository<ChampionDto, String>{
	
	@Query(value = "select name from champion order by name",nativeQuery = true)
	List<ChampionName> findName();
}
