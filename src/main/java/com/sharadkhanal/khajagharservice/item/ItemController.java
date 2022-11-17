package com.sharadkhanal.khajagharservice.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/khaja_ghar/itemPost")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ItemResponseDto addItems(@RequestBody ItemCreateDto itemCreateDto) {
		return itemService.addItems(itemCreateDto);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemResponseListDto getItems() {
		return itemService.getitems();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemResponseDto getItemById(@PathVariable("id") long id) {
		return itemService.getItemById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ItemResponseDto updateItem(@PathVariable("id") long id, @RequestBody ItemUpdateDto itemUpdateDto) {
		return itemService.updateItem(id, itemUpdateDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteByItemId(@PathVariable("id") long id) throws Exception {
		itemService.deleteByItemId(id);
	}

}
