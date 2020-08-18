package com.revature.services;

import java.util.List;

import com.revature.models.BattleClass;
import com.revature.repositories.BattleClassRepository;
import com.revature.repositories.BattleClassRepositoryImpl;

public class BattleClassServiceImpl implements BattleClassService {
	BattleClassRepository bcr = new BattleClassRepositoryImpl();

	public int addBattleClass(BattleClass battleClass) {
		return bcr.addBattleClass(battleClass);
	}

	public List<BattleClass> getAllBattleClass(){
		return bcr.getAllBattleClass();
	}

	public BattleClass getBattleClass(int id) {
		return bcr.getBattleClass(id);
	}

	public BattleClass getBattleClass(String title) {
		return bcr.getBattleClass(title);
	}

	public void updateBattleClass(BattleClass battleClass) {
		 bcr.updateBattleClass(battleClass);
		
	}
	
	public void deleteBattleClass(int id) {
		bcr.deleteBattleClass(id);
	}

}
