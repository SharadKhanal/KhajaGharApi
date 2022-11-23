package com.sharadkhanal.khajagharservice.item;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ItemResponseDto {
	@Id
	private long id;
	private String itemName;
	private String itemPrice;
	private String itemPicture;
	private String validDate;
}
