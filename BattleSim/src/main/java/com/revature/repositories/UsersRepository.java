package com.revature.repositories;

import java.util.List;

import com.revature.models.Users;

public interface UsersRepository {
	
	public int addUser(Users u);
	public List<Users> getAllUsers();
	public Users getUser(int id);
	public Users login(String username, String password);
	public void updateUser(Users change);
	public void deleteUser(int id);
}
