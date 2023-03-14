package com.shop.service;

import javax.transaction.Transactional;

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
		String password = member.getPassword();
		String encordPassword = passwordEncoder.encode(password);
		member.setPassword(encordPassword);
		member.setRole(MemberRole.MEMBER);
		
		Member memberEntity = memberRepository.save(member);
		return memberEntity;
	}
	
	@Transactional // Write(Insert, Update, Delete)
    public Member userUpdate(Member member) {
		Member memberEntity = memberRepository.save(member);
        return memberEntity;
    }
}
