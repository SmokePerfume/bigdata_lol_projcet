package com.lol.analysis.repository;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.vo.PredVo;

public interface ChampionRepository extends CrudRepository<ChampionDto, String>{
	
	
	public Iterable<ChampionDto> findAllByOrderByNameAsc();

	public ChampionDto findByCode(int code);
	

	
	@Query(nativeQuery=true,value="SELECT * FROM pred ORDER BY predno desc limit 1")
	public List<PredVo> findLastPredTuple();
	
}
