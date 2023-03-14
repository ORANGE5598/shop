package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.dto.SignUpDTO;
import com.shop.entity.Member;
import com.shop.service.AuthService;
import com.shop.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final AuthService authService; 
	private final MemberService memberService;
	
	@GetMapping("/signin")
	public String signinForm() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}
	
//	@PostMapping("/signup") 
//	public String signup(SignUpDTO signupDTO) {
//		Member member = memberService.dtoToEntity(signupDTO);
//	}
	

}
