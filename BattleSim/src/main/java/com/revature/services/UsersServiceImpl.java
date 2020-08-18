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

	public Users getUser(int id) {
		return ur.getUser(id);
	}

	public Users getUser(String username) {
		return ur.getUser(username);
	}
	
	public Users login(String username, String password) {
		Users u = ur.getUser(username);
		if(u != null) {
			if(u.getPassword().equals(password)) {
				return u;
			}			
		}
		return null;
	}

	public void updateUsers(Users change) {
		ur.updateUser(change);
	}

	public void deleteUsers(int id) {
		ur.deleteUser(id);
	}

	public List<Users> getUsersByRole(int id) {
		return ur.getUsersByRole(id);
	}

}
