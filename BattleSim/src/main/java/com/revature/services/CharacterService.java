package com.revature.services;

import java.util.List;

import com.revature.models.Character;

public interface CharacterService {

	public int addCharacter(Character character);
	public List<Character> getAllCharacters();
	public Character getCharacter(int id);
	public void updateCharacter(Character character);
	public void deleteCharacter(int id);
}
