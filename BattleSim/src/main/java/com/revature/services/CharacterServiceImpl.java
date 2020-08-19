package com.revature.services;

import java.util.List;

import com.revature.models.Character;
import com.revature.repositories.CharacterRepository;
import com.revature.repositories.CharacterRepositoryImpl;

public class CharacterServiceImpl implements CharacterService {

	public CharacterRepository cr = new CharacterRepositoryImpl();
	
	public int addCharacter(Character character) {
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
