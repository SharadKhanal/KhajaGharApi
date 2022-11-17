package com.sharadkhanal.khajagharservice.itemOrder;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ItemOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	LocalDateTime createdDateTime = LocalDateTime.now();
	private Long itemId;
	private Long userId;
}
