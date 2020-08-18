package com.revature.services;

import java.util.List;

import com.revature.models.Users;
import com.revature.repositories.UsersRepository;
import com.revature.repositories.UsersRepositoryImpl;

public class UsersServiceImpl implements UsersService{

	private UsersRepository ur = new UsersRepositoryImpl();
	
	public int addUsers(Users u) {
		return ur.addUser(u);
	}

	public List<Users> getAllUsers() {
		return ur.getAllUsers();
	}

	public Users getUsers(int id) {
		return ur.getUser(id);
	}

	public Users login(String username, String password) {
		return ur.login(username, password);
	}

	public void updateUsers(Users change) {
		ur.updateUser(change);
	}

	public void deleteUsers(int id) {
		ur.deleteUser(id);
	}

}
