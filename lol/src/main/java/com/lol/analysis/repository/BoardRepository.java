package com.lol.analysis.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lol.analysis.vo.BoardVo;


public interface BoardRepository extends JpaRepository<BoardVo, Integer>{
	//멤버리스트 출력	
	public Page<BoardVo> findAll(Pageable pageable);

	public BoardVo findByTitle(String title);
	
	
	

}
