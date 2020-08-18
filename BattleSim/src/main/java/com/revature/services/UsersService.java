package com.revature.services;

import java.util.List;

import com.revature.models.Users;

public interface UsersService {
	
	public int addUsers(Users u);
	public List<Users> getAllUsers();
	public Users getUsers(int id);
	public Users login(String username, String password);
	public void updateUsers(Users change);
	public void deleteUsers(int id);
}
