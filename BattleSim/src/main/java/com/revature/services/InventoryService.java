package com.revature.services;

import java.util.List;

import com.revature.models.Inventory;

public interface InventoryService {

	public int addInventory(Inventory inv);
	public List<Inventory> getAllInventories();
	public Inventory getInventory(int id);
	public void updateInventory(Inventory inv);
	public void deleteInventory(int i_id);
}
