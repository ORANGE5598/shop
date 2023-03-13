package com.shop.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dto.ItemDTO;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	
	private String fileDir = "https://i.imgur.com/";
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ItemDTO getImg(Long iNumber) {
		
		Optional<Item> result = itemRepository.findById(iNumber);
		
		return result.isPresent()?entityToDto(result.get()):null;
	}

	@Override
	public Long management(ItemDTO dto, MultipartFile file) {
		
		
		if(file.isEmpty()) {
			return null;
		}
		
		// 요청한 원본 파일명 추출
		String orginName = file.getOriginalFilename();
		
		// 파일을 불러올 때 사용할 경로
		String savedPath = fileDir + orginName;
		
		System.out.println("++++++" + savedPath);
		
		Item entity = dtoToEntity(dto).builder()
				.iCategory(dto.getICategory()).iDeliveryPrice(dto.getIDeliveryPrice())
				.iInfo(dto.getIInfo()).iInstock(dto.getIInstock())
				.iName(dto.getIName()).iPrice(dto.getIPrice())
				.iImg(savedPath).build();
		
		itemRepository.save(entity);
		
		return entity.getINumber();
	}
	
}
