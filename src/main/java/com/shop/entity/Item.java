package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iNumber;
	private String iName;
	
	private String iCategory;
	private Long iPrice;
	private Long iDeliveryPrice;
	private String iInfo;
	private Long iInstock;
	private String iImg;
	
	public void changeImg(String iImg) {
		this.iImg = iImg;
	}
	
}