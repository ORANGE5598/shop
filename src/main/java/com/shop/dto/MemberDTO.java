package com.shop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 
 * MemberDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
	
	
	private String id;				// 회원 ID. (PK)
	private String password;		// 회원 패스워드.
	private String name;			// 회원 실명.
	private String email;			// 회원 이메일. (unique)
	private String address;			// 회원 주소.
	private String phoneNumber;		// 회원 휴대폰번호.
	private Long point;				// 회원 적립포인트.
	
	private LocalDateTime regDate;	// 회원 가입일.
	private LocalDateTime modDate;	// 회원 정보 수정일.
}
