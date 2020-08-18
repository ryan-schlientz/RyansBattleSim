package com.revature.repositories;

import java.util.List;

import javax.management.relation.Role;

public interface RolesRepository {
	public int addRole(Role r);
	public List<Role> getAllRoles();
	public Role getRole(int id);
//	public Role getRole(name);
	public void updateRoles(Role change);
	public void deleteRoles(int id);
}
