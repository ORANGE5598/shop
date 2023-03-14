package com.shop.config.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("로그인 요청된 유저 정보 : " + username);
		
		Optional<Member> result = memberRepository.findById(username);
		
		Member memberEntity = result.get();
		System.out.println("찾은 사용자 정보 : " + memberEntity);
		
		if(!result.isPresent()) {
			throw new UsernameNotFoundException("사용자 정보를 찾을 수 없읍니다.");
		} else {
			return new PrincipalDetails(memberEntity);
		}
		
	}
}
