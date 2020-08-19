package com.revature.services;

import java.util.List;

import com.revature.models.Inventory;
import com.revature.repositories.InventoryRepository;
import com.revature.repositories.InventoryRepositoryImpl;

public class InventoryServiceImpl implements InventoryService {

	InventoryRepository ir = new InventoryRepositoryImpl();
	
	public int addInventory(Inventory inv) {
		return ir.addInventory(inv);
	}

	public List<Inventory> getAllInventories() {
		return ir.getAllInventories();
	}

	public Inventory getInventory(int id) {
		return ir.getInventory(id);
	}

	public void updateInventory(Inventory inv) {
		ir.updateInventory(inv);
	}

	public void deleteInventory(int i_id) {
		ir.deleteInventory(i_id);
	}

}
