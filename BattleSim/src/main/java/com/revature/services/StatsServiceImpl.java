package com.revature.services;

import java.util.List;

import com.revature.models.Stats;
import com.revature.repositories.StatsRepository;
import com.revature.repositories.StatsRepositoryImpl;

public class StatsServiceImpl implements StatsService {
	StatsRepository sr = new StatsRepositoryImpl();

	public int addStats(Stats stats) {
		return sr.addStats(stats);
	}

	public List<Stats> getAllStats() {
		return sr.getAllStats();
	}

	public Stats getStats(int id) {
		return sr.getStats(id);
	}

	public boolean updateStats(Stats stats) {
		return sr.updateStats(stats);
	}
	
	public boolean deleteStats(Stats stats) {
		return sr.deleteStats(stats);
	}

}
