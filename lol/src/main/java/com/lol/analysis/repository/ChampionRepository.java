package com.lol.analysis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.lol.analysis.dto.ChampionDto;
import com.lol.analysis.vo.PredVo;

public interface ChampionRepository extends CrudRepository<ChampionDto, String>{
	public Iterable<ChampionDto> findAllByOrderByNameAsc();

	public ChampionDto findByCode(int code);
	
	public Page<ChampionDto> findAll(Pageable pageable);

	public ChampionDto findByName(String name);

	
	@Query(nativeQuery=true,value="SELECT * FROM pred ORDER BY predno desc limit 1")
	public List<PredVo> findLastPredTuple();
	
	@Query(nativeQuery = true,value = "select * from champion where name like concat ('%',?1,'%')")
    public List<ChampionDto> findLikeName(String id);
	
}
