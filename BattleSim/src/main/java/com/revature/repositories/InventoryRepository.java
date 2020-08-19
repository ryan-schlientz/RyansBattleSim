package com.revature.repositories;

import java.util.List;

import com.revature.models.Inventory;

public interface InventoryRepository {

	public int addInventory(Inventory inv);
	public List<Inventory> getAllInventories();
	public Inventory getInventory(int id);
	public void updateInventory(Inventory inv);
	public void deleteInventory(int i_id);
}
