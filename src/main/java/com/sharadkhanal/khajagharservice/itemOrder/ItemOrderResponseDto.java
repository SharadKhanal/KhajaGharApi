package com.sharadkhanal.khajagharservice.itemOrder;

import java.time.LocalDateTime;


import com.sharadkhanal.khajagharservice.item.ItemResponseDto;

import lombok.Data;

@Data
public class ItemOrderResponseDto {
	private Long id;
	private LocalDateTime createdDateTime;
	private ItemResponseDto item;
	private Long userId;
}
