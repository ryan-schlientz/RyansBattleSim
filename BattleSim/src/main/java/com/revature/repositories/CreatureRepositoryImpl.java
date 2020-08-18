package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.models.Creature;
import com.revature.util.HibernateUtil;

public class CreatureRepositoryImpl implements CreatureRepository {

	
	public int addCreature(Creature creature) {
		 Session sess = HibernateUtil.getSession();
		 int id = 0;
	        try {
	            sess.beginTransaction();
	            id = Integer.parseInt(sess.save(creature).toString());
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }
		return id;
	}

	
	public List<Creature> getAllCreatures() {
		 Session sess = HibernateUtil.getSession();
		 List<Creature> list = null;
	        try {
	           list = sess.createQuery("FROM creature").list();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return list;
	}

	
	public Creature getCreature(int id) {
		 Session sess = HibernateUtil.getSession();
		 Creature cr = null;
	        try {
	        	cr = (Creature) sess.get(Creature.class, id);
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return cr;
	}

	
	public Creature getCreature(String name) {
		 Session sess = HibernateUtil.getSession();
		 Creature cr = null;
	        try {
	          Criteria crit = sess.createCriteria(Creature.class);
	          crit.add(Restrictions.eq("name", name));
	          cr = (Creature) crit.uniqueResult();
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return cr;
	}

	
	public void updateCreature(Creature creature) {
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            sess.merge(creature);
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }
		
	}

	
	public void deleteCreature(int id) {
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            sess.delete(sess.get(Creature.class, id));
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }
		
	}

}
