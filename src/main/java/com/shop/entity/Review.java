package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Review {
	
	@Id
	private Long rno;
	
	private String rTitle;
	private String rContent;
	private String rWirter;
	private String rImg;
	
	public void changerTitle(String title) {
		this.rTitle = title;
	}
	
	public void cangerContent(String content) {
		this.rContent = content;
	}

}
