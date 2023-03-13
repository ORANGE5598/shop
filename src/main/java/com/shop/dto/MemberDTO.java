package com.shop.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	@NotEmpty(message = "아이디를 입력해주세요.")
	@Size(min = 4, max = 16, message = "아이디는 4 ~ 16자 사이여야 합니다.")
	private String id;				// 회원 ID. (PK)
	
	@NotEmpty(message = "패스워드를 입력해주세요.")
	@Size(min = 4, max = 16, message = "패스워드는 4 ~ 16자 사이여야 합니다.")
	private String password;		// 회원 패스워드.
	
	@NotEmpty(message = "이름을 입력해주세요.")
	private String name;			// 회원 실명.
	
	@NotEmpty(message = "이메일을 입력해주세요.")
	private String email;			// 회원 이메일. (unique)
	
	@NotBlank(message = "주소를 입력해주세요.")
	private String address;			// 회원 주소.
	private String phoneNumber;		// 회원 휴대폰번호.
	private Long point;				// 회원 적립포인트.
	
	private LocalDateTime regDate;	// 회원 가입일.
	private LocalDateTime modDate;	// 회원 정보 수정일.
}
