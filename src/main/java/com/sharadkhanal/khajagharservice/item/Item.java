package com.sharadkhanal.khajagharservice.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String itemName;

	@Column(nullable = false)
	private String itemPrice;
	
	
//	private String mediaType; 
	
//	@Column(nullable=false)
	private String itemPicture;
	
	@Column(nullable = false)
	private String validDate;
}
