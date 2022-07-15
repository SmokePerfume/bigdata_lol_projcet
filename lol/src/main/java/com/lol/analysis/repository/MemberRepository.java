package com.lol.analysis.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lol.analysis.vo.MemGenderCntVo;
import com.lol.analysis.vo.MemberVo;

@Repository
public interface MemberRepository extends CrudRepository<MemberVo, String>{
	//멤버리스트 출력	
	public Page<MemberVo> findAll(Pageable pageable);
	
	//로그인 id, pw 확인
	public MemberVo findByIdAndPw(String id, String pw);
	
	
	//ajax로 중복 검사
	public Optional<MemberVo> findByEmail(String email);
    public Optional<MemberVo> findByPhone(String phone);
    
//    @Query(value="SELECT gender, count(*) AS cnt FROM member GROUP BY gender ORDER BY cnt DESC", nativeQuery = true)
//    public Iterable<MemGenderCntVo> findGenderCountWithMember();

}
