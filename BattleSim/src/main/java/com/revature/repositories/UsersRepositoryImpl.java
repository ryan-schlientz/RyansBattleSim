package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class UsersRepositoryImpl implements UsersRepository {

	public int addUsers(Users u) {
		Session sess = HibernateUtil.getSession();
		int id = -1;
		try {
			sess.beginTransaction();
			id = (Integer) sess.save(u);
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}
		return id;
	}

	public List<Users> getAllUsers() {
		Session sess = HibernateUtil.getSession();
		List<Users> Users = null;
		try {
			Users = sess.createQuery("FROM users").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return Users;
	}

	public Users getUsers(int id) {
		Session sess = HibernateUtil.getSession();
		Users u = null;
		try {
			u = (Users) sess.get(Users.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return u;
	}

	public void updateUsers(Users change) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			sess.update(change);
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

	}

	public void deleteUsers(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			sess.delete(id);
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}

	}

	public Users login(String username, String password) {
		Users u = null;
		Session sess = HibernateUtil.getSession();
		try {
			Criteria crit = sess.createCriteria(Users.class);
			crit.add(Restrictions.eq("username", username));
			crit.add(Restrictions.eq("password", password));
			u = (Users) crit.uniqueResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return u;
	}

}
