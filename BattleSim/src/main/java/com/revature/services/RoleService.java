package com.revature.services;

import java.util.List;
import com.revature.models.Roles;

public interface RoleService {
	public int addRole(Roles r);
	public List<Roles> getAllRoles();
	public Roles getRole(int id);
	public void updateRole(Roles change);
	public void deleteRole(int id);
}
