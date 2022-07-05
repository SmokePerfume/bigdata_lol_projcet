package com.lol.analysis.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.vo.MemberVo;

public interface MemberRepository extends CrudRepository<MemberVo, String>{
	public Page<MemberVo> findAll(Pageable pageable);
	

}
