package com.revature.services;

import java.util.List;

import com.revature.models.Creature;

public interface CreatureService {
	
	public int addCreature(Creature creature);
	public List<Creature> getAllCreatures();
	public List<Creature> getCreaturesByClass(int id);
	public Creature getCreature(int id);
	public Creature getCreature(String name);
	public void updateCreature(Creature creature);
	public void deleteCreature(int id);
	 
}
