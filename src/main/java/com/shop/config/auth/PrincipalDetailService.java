package com.shop.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shop.entity.Member;
import com.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member memberEntity = memberRepository.findByUsername(username);
		
		if(memberEntity == null) {
			return null;
		} else {
			return new PrincipalDetails(memberEntity);
		}
	}

}
