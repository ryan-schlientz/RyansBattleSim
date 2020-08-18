package com.revature.repositories;

import java.util.List;

import com.revature.models.Users;

public interface UsersRepository {
	
	public int addUsers(Users r);
	public List<Users> getAllUsers();
	public Users getUsers(int id);
	public Users login(String username, String password);
	public void updateUsers(Users change);
	public void deleteUsers(int id);
}
