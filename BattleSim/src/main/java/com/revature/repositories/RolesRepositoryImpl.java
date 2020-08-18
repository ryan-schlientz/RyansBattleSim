package com.revature.repositories;

import java.util.List;

import javax.management.relation.Role;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.util.HibernateUtil;

public class RolesRepositoryImpl implements RolesRepository {

	public int addRole(Role r) {
		Session sess = HibernateUtil.getSession();
		int id = -1;
		try {
			sess.beginTransaction();
			id = (Integer) sess.save(r);
			sess.getTransaction().commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		return id;
	}

	public List<Role> getAllRoles() {
		Session sess = HibernateUtil.getSession();
		List<Role> roles = null;
		try {
			roles = sess.createQuery("FROM roles").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return roles;
	}

	public Role getRole(int id) {
		Session sess = HibernateUtil.getSession();
		Role r = null;
		try {
			r = (Role) sess.get(Role.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return r;
	}

	public void updateRoles(Role change) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			sess.update(change);
			sess.getTransaction().commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

	}

	public void deleteRoles(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			sess.delete(id);
			sess.getTransaction().commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

	}

}
