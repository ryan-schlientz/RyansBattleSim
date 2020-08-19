package com.revature.repositories;

import java.util.List;

import com.revature.models.Roles;

public interface RolesRepository {
	public int addRole(Roles r);
	public List<Roles> getAllRoles();
	public Roles getRole(int id);
	public void updateRole(Roles change);
	public void deleteRole(int id);
}
