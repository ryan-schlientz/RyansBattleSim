package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Roles;
import com.revature.util.HibernateUtil;

public class RolesRepositoryImpl implements RolesRepository {

	public int addRole(Roles r) {
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

	public List<Roles> getAllRoles() {
		Session sess = HibernateUtil.getSession();
		List<Roles> roles = null;
		try {
			roles = sess.createQuery("FROM roles").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return roles;
	}

	public Roles getRole(int id) {
		Session sess = HibernateUtil.getSession();
		Roles r = null;
		try {
			r = (Roles) sess.get(Roles.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return r;
	}

	public void updateRole(Roles change) {
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

	public void deleteRole(int id) {
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
