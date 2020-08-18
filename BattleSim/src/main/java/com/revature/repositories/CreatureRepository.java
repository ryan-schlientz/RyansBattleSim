package com.revature.repositories;

import java.util.List;

import com.revature.models.Creature;



public interface CreatureRepository {
	
	public int addCreature(Creature creature);
	public List<Creature> getAllCreatures();
	public Creature getCreature(int id);
	public Creature getCreature(String name);
	public void updateCreature(Creature creature);
	public void deleteCreature(int id);

}
