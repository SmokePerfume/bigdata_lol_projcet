package com.lol.analysis.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.lol.analysis.vo.MemberVo;

public interface MemberRepository extends CrudRepository<MemberVo, String>{
	//멤버리스트 출력	
	public Page<MemberVo> findAll(Pageable pageable);
	
	//로그인 id, pw 확인
	public MemberVo findByIdAndPw(String id, String pw);
	
	//ajax로 중복 검사
	public Optional<MemberVo> findByEmail(String email);
    public Optional<MemberVo> findByPhone(String phone);

}
