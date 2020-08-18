package com.revature.repositories;

import java.util.List;

import com.revature.models.Item;

public interface ItemRepository {
	public int addItem(Item item);
	public List<Item> getAllItems();
	public Item getItem(int id);
	public boolean updateItem(Item item);
	public boolean deleteItem(Item item);
}
