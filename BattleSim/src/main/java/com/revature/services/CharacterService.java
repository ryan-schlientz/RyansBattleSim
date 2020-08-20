package com.revature.services;

import java.util.List;

import com.revature.models.Character;
import com.revature.models.Users;

public interface CharacterService {

	public int addCharacter(Users user, String battleClass, String creatureName);
	public List<Character> getAllCharacters();
	public Character getCharacter(int id);
	public void updateCharacter(Character character);
	public void deleteCharacter(int id);
}
