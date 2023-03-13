package com.shop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
	
	private Long oNumber;
	
	private String id;
	private String iName;
	
	private String iInfo;
	private Long iPrice;
	
	private LocalDateTime regDate, modDate;
	
	private String iImg;

}
