package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.models.Character;
import com.revature.models.Creature;
import com.revature.util.HibernateUtil;

public class CharacterRepositoryImpl implements CharacterRepository {

	public int addCharacter(Character character) {
		Session sess = HibernateUtil.getSession();
		 int id = 0;
	        try {
	            sess.beginTransaction();
	            id = Integer.parseInt(sess.save(character).toString());
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }
		return id;
	}

	public List<Character> getAllCharacters() {
		 Session sess = HibernateUtil.getSession();
		 List<Character> list = null;
	        try {
	           list = sess.createQuery("FROM character").list();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return list;
	
	}

	public Character getCharacter(int id) {
		 Session sess = HibernateUtil.getSession();
		 Character ch = null;
	        try {
	        	ch = (Character) sess.get(Character.class, id);
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return ch;
	}


	public void updateCharacter(Character character) {
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            sess.merge(character);
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }

	}

	public void deleteCharacter(int id) {
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            sess.delete(sess.get(Character.class, id));
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }

	}

}
