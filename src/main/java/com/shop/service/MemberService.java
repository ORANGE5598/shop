package com.shop.service;

import com.shop.dto.MemberDTO;
import com.shop.entity.Member;

public interface MemberService {

	Long signin(MemberDTO memberDTO);
	
	default Member dtoToEntity(MemberDTO dto) {
		Member member = Member.builder()
				.email(dto.getEmail())
				.id(dto.getId())
				.name(dto.getName())
				.password(dto.getPassword())
				.phoneNumber(dto.getPhoneNumber())
				.point(dto.getPoint())
				.build();
		return member;
	}
	
	default MemberDTO entityToDTO(Member member) {
		MemberDTO dto = MemberDTO.builder()
				.email(member.getEmail())
				.id(member.getId())
				.name(member.getName())
				.password(member.getPassword())
				.phoneNumber(member.getPhoneNumber())
				.point(member.getPoint())
				.modDate(member.getModDate())
				.regDate(member.getRegDate())
				.build();
		return dto;
	}
	
	
}
