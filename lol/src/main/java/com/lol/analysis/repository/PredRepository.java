package com.lol.analysis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lol.analysis.vo.BoardVo;
import com.lol.analysis.vo.PredVo;


public interface PredRepository extends CrudRepository<PredVo, Integer>{

	public Page<PredVo> findAll(Pageable pageable);
	
	@Query(nativeQuery=true, value="SELECT * FROM pred ORDER BY predno desc limit 1")
	public List<PredVo> findLastPredTuple();
	
	
	
	
	

}
