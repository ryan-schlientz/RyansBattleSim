package com.revature.repositories;

import java.util.List;

import com.revature.models.Stats;

public interface StatsRepository {
	public int addStats(Stats stats);
	public List<Stats> getAllStats();
	public Stats getStats(int id);
	public boolean updateStats(Stats stats);
	
}
