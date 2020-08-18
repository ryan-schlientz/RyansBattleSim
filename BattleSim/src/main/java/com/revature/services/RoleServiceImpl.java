package com.revature.services;

import java.util.List;

import javax.management.relation.Role;

import com.revature.repositories.RolesRepository;
import com.revature.repositories.RolesRepositoryImpl;

public class RoleServiceImpl implements RoleService{

	private RolesRepository rr = new RolesRepositoryImpl();
	
	public int addRole(Role r) {
		return rr.addRole(r);
	}

	public List<Role> getAllRoles() {
		return rr.getAllRoles();
	}

	public Role getRole(int id) {
		return rr.getRole(id);
	}

	public void updateRoles(Role change) {
		rr.updateRoles(change);
	}

	public void deleteRoles(int id) {
		rr.deleteRoles(id);
	}

}
