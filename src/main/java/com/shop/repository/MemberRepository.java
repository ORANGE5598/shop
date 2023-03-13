package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	Member findByEmail(String email);
	
	@Query("SELECT m FROM Member m WHERE m.id =:id")
	Optional<Member> findById(@Param("id") String email);
	
}
