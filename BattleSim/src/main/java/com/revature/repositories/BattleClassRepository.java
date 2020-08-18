package com.revature.repositories;

import java.util.List;

import com.revature.models.BattleClass;

public interface BattleClassRepository {
	
	public int addBattleClass(BattleClass battleClass);
	public List<BattleClass> getAllBattleClass();
	public BattleClass getBattleClass(int id);
	public BattleClass getBattleClass(String title);
	public void updateBattleClass(BattleClass battleClass);
	public void deleteBattleClass(int id);

}
