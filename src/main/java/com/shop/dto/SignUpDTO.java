package com.shop.dto;

import com.shop.entity.Member;

import lombok.Data;

@Data
public class SignUpDTO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	
	public Member toEntity() {
		return Member.builder()
				.id(id)
				.password(password)
				.name(name)
				.email(email)
				.address(address)
				.phoneNumber(phoneNumber)
				.build();
	}

}
