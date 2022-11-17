package com.sharadkhanal.khajagharservice.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public ItemResponseDto addItems(ItemCreateDto itemCreateDto) {
		Item item = new Item();
		item.setId(itemCreateDto.getId());
		item.setItemName(itemCreateDto.getItemName());
		item.setItemPicture(itemCreateDto.getItemPicture());
		item.setItemPrice(itemCreateDto.getItemPrice());
		item.setValidDate(itemCreateDto.getValidDate());

		Item savedItem = itemRepository.save(item);
		return getItemResponseDto(savedItem);
	}

	public ItemResponseDto getItemResponseDto(Item item) {
		ItemResponseDto response = new ItemResponseDto();
		response.setId(item.getId());
		response.setItemName(item.getItemName());
		response.setItemPicture(item.getItemPicture());
		response.setItemPrice(item.getItemPrice());
		response.setValidDate(item.getValidDate());

		return response;
	}

	public ItemResponseListDto getitems() {

		List<ItemResponseDto> itemResponseDto = new ArrayList<>();
		List<Item> items = (List<Item>) itemRepository.findAll();

		for (Item item : items) {
			itemResponseDto.add(getItemResponseDto(item));
		}

		ItemResponseListDto response = new ItemResponseListDto();
		response.setItems(itemResponseDto);
		response.setTotal((long) itemResponseDto.size());
		return response;
	}

	public ItemResponseDto updateItem(long id, ItemUpdateDto itemUpdateDto) {
		Optional<Item>optionalItem=itemRepository.findById(id);
		
		if(optionalItem.isPresent()) {
			Item item=optionalItem.get();
			item.setItemName(itemUpdateDto.getItemName());
			item.setItemPicture(itemUpdateDto.getItemPicture());
			item.setItemPrice(itemUpdateDto.getItemPrice());
			item.setValidDate(itemUpdateDto.getValidDate());
			
			Item savedItem=itemRepository.save(item);
			return getItemResponseDto(savedItem);
		}
		return null;
	}

	public void deleteByItemId(long id)throws Exception {
		Optional<Item>optionalItem=itemRepository.findById(id);
//		Item item=optionalItem.get();
		if(optionalItem.isPresent()) {
			
			itemRepository.deleteById(id);
		}
		else {
			throw new Exception("The given Item is not available!!!");
		}
		
	}

}
