package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.entity.Member;
import com.shop.service.AuthService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {

	private final AuthService authService;
	
	@GetMapping("/signin")
	public String signinForm() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Member member) {
		Member newMember = member;
		Member memberEntity = authService.signup(newMember);
		
		System.out.println("가입자 정보 : " + newMember);
		return "signin";
	}
}
