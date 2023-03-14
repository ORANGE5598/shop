package com.shop.service;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.entity.Member;
import com.shop.entity.MemberRole;
import com.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;

	
	@Transactional
	public Member signup(Member member) {
		String originPassword = member.getPassword();
		String encordPassword = passwordEncoder.encode(originPassword);
		member.setPassword(encordPassword);
		member.setRole(MemberRole.MEMBER);
		
		Member memberEntity = memberRepository.save(member);
		return memberEntity;
	}
	
}
