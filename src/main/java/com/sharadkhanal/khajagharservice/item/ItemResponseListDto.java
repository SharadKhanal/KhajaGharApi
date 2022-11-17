package com.sharadkhanal.khajagharservice.item;

import java.util.List;

import lombok.Data;
@Data
public class ItemResponseListDto {
	private List<ItemResponseDto>items;
	private long total;
}
