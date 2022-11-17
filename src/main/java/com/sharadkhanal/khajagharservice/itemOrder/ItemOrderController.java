package com.sharadkhanal.khajagharservice.itemOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/khaja_ghar/order")
public class ItemOrderController {
	@Autowired
	private ItemOrderService itemOrderService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ItemOrderResponseDto makeOrder(@RequestBody ItemOrderCreateDto order) {
		return itemOrderService.makeOrder(order);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOrderResponseListDto getItemOrders() {
		return itemOrderService.getItemOrders();
	}
}
