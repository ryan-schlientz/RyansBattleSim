package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Creature;
import com.revature.repositories.CreatureRepository;
import com.revature.repositories.CreatureRepositoryImpl;

public class CreatureServiceImpl implements CreatureService{

private CreatureRepository cr = new CreatureRepositoryImpl();
	
	public int addCreature(Creature u) {
		return cr.addCreature(u);
	}

	public List<Creature> getAllCreatures() {
		return cr.getAllCreatures();
	}

	public Creature getCreature(int id) {
		return cr.getCreature(id);
	}
	
	public Creature getRandomCreature() {
		List<Creature> creatures = cr.getAllCreatures();
		int index = (int) (Math.random() * creatures.size());
		return creatures.get(index);
	}

	public Creature getCreature(String Creaturename) {
		return cr.getCreature(Creaturename);
	}

	public void updateCreature(Creature change) {
		cr.updateCreature(change);
	}

	public void deleteCreature(int id) {
		cr.deleteCreature(id);
	}

	public List<Creature> getCreaturesByClass(int id) {
		List<Creature> creats = new ArrayList<Creature>();
		List<Creature> returns = new ArrayList<Creature>();
		
		creats = cr.getAllCreatures();
		for(Creature c :  creats) {
			if(c.getBattleClass().getClassId() == id) {
				returns.add(c);
			}
		}
		return returns;
	}

}
