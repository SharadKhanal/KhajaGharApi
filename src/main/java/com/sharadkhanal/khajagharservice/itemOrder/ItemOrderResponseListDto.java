package com.sharadkhanal.khajagharservice.itemOrder;

import java.util.List;

import lombok.Data;
@Data
public class ItemOrderResponseListDto {
	private List<ItemOrderResponseDto>itemOrders;
	private Long total;
}
