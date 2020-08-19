package com.revature.services;

import java.util.List;

import com.revature.models.Stats;

public interface StatsService {

	public int addStats(Stats stats);
	public List<Stats> getAllStats();
	public Stats getStats(int id);
	public boolean updateStats(Stats stats);
	public boolean deleteStats(Stats stats);
}
