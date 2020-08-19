package com.revature.services;

import java.util.List;
import com.revature.models.Roles;
import com.revature.repositories.RolesRepository;
import com.revature.repositories.RolesRepositoryImpl;

public class RoleServiceImpl {

	private RolesRepository rr = new RolesRepositoryImpl();
	
	public int addRole(Roles r) {
		return rr.addRole(r);
	}

	public List<Roles> getAllRoles() {
		return rr.getAllRoles();
	}

	public Roles getRole(int id) {
		return rr.getRole(id);
	}

	public void updateRole(Roles change) {
		rr.updateRole(change);
	}

	public void deleteRole(int id) {
		rr.deleteRole(id);
	}

}
