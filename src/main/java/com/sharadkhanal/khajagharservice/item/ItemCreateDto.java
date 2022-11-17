package com.sharadkhanal.khajagharservice.item;

import lombok.Data;

@Data
public class ItemCreateDto {
	public static final long serialVersionUID = 1L;
	private Long id;
	private String itemName;
	private String itemPrice;
	private String itemPicture;
	private String validDate;
}
