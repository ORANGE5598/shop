package com.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int user_num;		// 유저 번호 부여. (PK)
	
	@Id
	@Column(nullable = false, unique = true)
	private String id;			// 로그인ID. (unique)
	
	@Column(nullable = false)
	private String password;	// 패스워드.
	
	@Column(nullable = false)
	private String name;		// 실명.
	
	@Column(nullable = false, unique = true)
	private String email;		// 이메일. (회원가입, 비밀번호 변경 등)
	
	private String address;
	
	@Column(nullable = false)
	private String phoneNumber;	// 휴대폰 번호.
	
	private String role;		// 권한.
	
	private Long point;
}
