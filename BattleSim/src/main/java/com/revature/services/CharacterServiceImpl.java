package com.revature.services;

import java.util.List;

import com.revature.models.BattleClass;
import com.revature.models.Character;
import com.revature.models.Creature;
import com.revature.models.Stats;
import com.revature.models.Users;
import com.revature.repositories.BattleClassRepositoryImpl;
import com.revature.repositories.CharacterRepository;
import com.revature.repositories.CharacterRepositoryImpl;
import com.revature.repositories.CreatureRepositoryImpl;
import com.revature.repositories.StatsRepositoryImpl;

public class CharacterServiceImpl implements CharacterService {

	public CharacterRepository cr = new CharacterRepositoryImpl();
	public StatsRepositoryImpl sr = new StatsRepositoryImpl();
	public CreatureRepositoryImpl creatureRepo = new CreatureRepositoryImpl();
	public BattleClassRepositoryImpl bcr = new BattleClassRepositoryImpl();
		
	
	public int addCharacter(Users user, String battleClass, String creatureName) {
		Creature charCreature = new Creature();
		Stats refStats = new Stats();
		Stats charStats = new Stats();
		Character character = new Character();
		BattleClass bc = new BattleClass();
		
		switch(battleClass) {
		case "Melee": refStats = sr.getStats(22);
			break;
		case "Ranged": refStats = sr.getStats(23);
			break;
		case "Mage": refStats = sr.getStats(24);
			break;
			
		}
		if(refStats != null) {
			charStats.setAttack(refStats.getAttack());
			charStats.setMaxHP(refStats.getMaxHP());
			charStats.setDefense(refStats.getDefense());
			charStats.setGold(refStats.getGold());
			charStats.setCurrentHealth(refStats.getCurrentHealth());
			charStats.setXp(0);
		}
		
		bc = bcr.getBattleClass(battleClass);
		
		charCreature.setBattleClass(bc);
		charCreature.setName(creatureName);
		
		charStats.setId(sr.addStats(charStats));
		charCreature.setStats(charStats);
		charCreature.setXpBase(10);
		
		charCreature.setCrId(creatureRepo.addCreature(charCreature));
		character.setCreature(charCreature);
		character.setUser(user);

		
		return cr.addCharacter(character);
	}

	public List<Character> getAllCharacters() {
		return cr.getAllCharacters();
	}

	public Character getCharacter(int id) {
		return cr.getCharacter(id);
	}

	public void updateCharacter(Character character) {
		cr.updateCharacter(character);
	}

	public void deleteCharacter(int id) {
		cr.deleteCharacter(id);
	}

}
