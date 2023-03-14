package com.shop.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SignInDTO {

	@NotNull(message = "아이디를 입력해주세요.")
	private String id;
	
	@NotNull(message = "비밀번호를 입력해주세요.")
	private String password;
	
}
