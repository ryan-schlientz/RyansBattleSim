package com.revature.repositories;

import java.util.List;

import com.revature.models.Item;

public interface ItemRepository {
	public int addItem(Item item);
	public List<Item> getAllItems();
	public Item getStats(int id);
	public boolean updateStats(Item item);
}
