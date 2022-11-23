package com.sharadkhanal.khajagharservice.itemOrder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharadkhanal.khajagharservice.item.ItemResponseDto;
import com.sharadkhanal.khajagharservice.item.ItemService;

@Service
public class ItemOrderService {
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	@Autowired
	private ItemService itemService;

	public ItemOrderResponseDto makeOrder(ItemOrderCreateDto order) {

		ItemOrderResponseDto responseDto = new ItemOrderResponseDto();

		ItemOrder itemOrder = new ItemOrder();
		itemOrder.setCreatedDateTime(LocalDateTime.now());
		itemOrder.setUserId(order.getUserId());
		itemOrder.setItemId(order.getItemId());
		ItemOrder savedItemOrder = itemOrderRepository.save(itemOrder);

		ItemResponseDto itemResponseDto = itemService.getItemById(order.getItemId());

		responseDto.setCreatedDateTime(itemOrder.getCreatedDateTime());
		responseDto.setId(savedItemOrder.getId());
		responseDto.setItem(itemResponseDto);
		responseDto.setUserId(savedItemOrder.getUserId());
		return responseDto;
	}

	public ItemOrderResponseDto getItemOrderResponseDto(ItemOrder itemOrder) {
		ItemOrderResponseDto response = new ItemOrderResponseDto();
		response.setCreatedDateTime(itemOrder.getCreatedDateTime());
		response.setId(itemOrder.getId());
		response.setUserId(itemOrder.getUserId());

		System.out.println("The given is is===="+itemOrder.getItemId());
		if(itemOrder.getItemId() !=null) {
		ItemResponseDto itemResponseDto = itemService.getItemById(itemOrder.getItemId());
		response.setItem(itemResponseDto);
		}
		return response;

	}

	public ItemOrderResponseListDto getItemOrders() {
		List<ItemOrderResponseDto> itemOrderResponseDto = new ArrayList<>();
		List<ItemOrder> itemOrders = itemOrderRepository.findAll();

		for (ItemOrder itemOrder : itemOrders) {
			itemOrderResponseDto.add(getItemOrderResponseDto(itemOrder));
		}

		ItemOrderResponseListDto response = new ItemOrderResponseListDto();
		response.setItemOrders(itemOrderResponseDto);
		response.setTotal((long) itemOrderResponseDto.size());

		return response;
	}

	public void deleteItemOrderById(long id) throws Exception {
		Optional<ItemOrder> optionalOrder = itemOrderRepository.findById(id);
		if (optionalOrder.isPresent()) {
			itemOrderRepository.deleteById(id);
		} else
			throw new Exception("The given Order id is not available!!");

	}

	public ItemOrderResponseDto updateItemOrder(long id, ItemOrderUpdateDto itemOrderUpdateDto) {
		ItemOrderResponseDto responseDto = new ItemOrderResponseDto();

		Optional<ItemOrder> optionalItemOrder = itemOrderRepository.findById(id);
		if (optionalItemOrder.isPresent()) {
			ItemOrder itemOrder = optionalItemOrder.get();
			itemOrder.setCreatedDateTime(LocalDateTime.now());
			
			itemOrder.setUserId(itemOrderUpdateDto.getUserId());
			System.out.println("UserId is====="+itemOrderUpdateDto.getUserId());
			
			itemOrder.setItemId(itemOrderUpdateDto.getItemId());
			System.out.println("Id is====="+itemOrderUpdateDto.getItemId());
			
			ItemOrder savedItemOrder = itemOrderRepository.save(itemOrder);

			ItemResponseDto itemResponseDto = itemService.getItemById(itemOrderUpdateDto.getItemId());

			responseDto.setCreatedDateTime(itemOrder.getCreatedDateTime());
			responseDto.setId(savedItemOrder.getId());
			responseDto.setItem(itemResponseDto);
			responseDto.setUserId(savedItemOrder.getUserId());
			return responseDto;

		}

		return null;
	}
}
