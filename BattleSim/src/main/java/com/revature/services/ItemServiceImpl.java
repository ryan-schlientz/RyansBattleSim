package com.revature.services;

import java.util.List;

import com.revature.models.Item;
import com.revature.repositories.ItemRepository;
import com.revature.repositories.ItemRepositoryImpl;

public class ItemServiceImpl implements ItemService {
	ItemRepository ir = new ItemRepositoryImpl();

	public int addItem(Item item) {
		return ir.addItem(item);
	}

	public List<Item> getAllItems() {
		return ir.getAllItems();
	}

	public Item getItem(int id) {
		return ir.getItem(id);
	}

	public boolean updateItem(Item item) {
		return ir.updateItem(item);
	}

	public boolean deleteItem(Item item) {
		return ir.deleteItem(item);
	}
}
