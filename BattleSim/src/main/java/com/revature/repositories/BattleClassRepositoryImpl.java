package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.models.BattleClass;
import com.revature.util.HibernateUtil;

import com.revature.util.HibernateUtil;




public class BattleClassRepositoryImpl implements BattleClassRepository {

	public int addBattleClass(BattleClass battleClass) {
		int id = 0;
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            id = Integer.parseInt(sess.save(battleClass).toString());
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }
		return id;
	}

	public List<BattleClass> getAllBattleClass() {
		 Session sess = HibernateUtil.getSession();
		 List<BattleClass> list = null;
	        try {
	        	
	        	list = sess.createQuery("FROM class").list();
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return list;
	}
  
	public BattleClass getBattleClass(int id) {
		 Session sess = HibernateUtil.getSession();
		 BattleClass bc = null;
	        try {
	        	bc = (BattleClass) sess.get(BattleClass.class, id);
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return bc;
	}

	public BattleClass getBattleClass(String title) {
		 Session sess = HibernateUtil.getSession();
		 BattleClass bc = null;
	        try {
	        	
	        	Criteria crit = sess.createCriteria(BattleClass.class);
	        	crit.add(Restrictions.eq("title", title));
	        	
	        	bc = (BattleClass) crit.uniqueResult();
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return bc;
	}

	public void updateBattleClass(BattleClass battleClass) {
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            sess.merge(battleClass);
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }

	}

	public void deleteBattleClass(int id) {
		 Session sess = HibernateUtil.getSession();
	        try {
	            sess.beginTransaction();
	            sess.delete(sess.get(BattleClass.class, id));
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }

	}

}
