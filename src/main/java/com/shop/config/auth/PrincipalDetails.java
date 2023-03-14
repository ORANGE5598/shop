package com.shop.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shop.entity.Member;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5572819756500788475L;
	
	private Member member;
	
	public PrincipalDetails(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collector = new ArrayList<>();
		collector.add(() -> {
			return member.getRole();
		});
		return collector;
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
