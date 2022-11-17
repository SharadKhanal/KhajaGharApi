package com.sharadkhanal.khajagharservice.item;

import lombok.Data;

@Data
public class ItemResponseDto {
	private long id;
	private String itemName;
	private String itemPrice;
	private String itemPicture;
	private String validDate;
}
