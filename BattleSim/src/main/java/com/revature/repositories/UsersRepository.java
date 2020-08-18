package com.revature.repositories;

import java.util.List;

import com.revature.models.Users;

public interface UsersRepository {
	
	public int addUser(Users u);
	public List<Users> getAllUsers();
	public List<Users> getUsersByRole(int id);
	public Users getUser(int id);
	public Users getUser(String username);
	public void updateUser(Users change);
	public void deleteUser(int id);
}
