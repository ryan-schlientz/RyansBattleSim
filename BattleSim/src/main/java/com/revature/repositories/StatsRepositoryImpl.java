package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Stats;
import com.revature.util.HibernateUtil;

public class StatsRepositoryImpl implements StatsRepository {

	@Override
	public int addStats(Stats stats) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = sess.beginTransaction();
			id = Integer.parseInt(sess.save(stats).toString());
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stats> getAllStats() {
		
		Session sess = HibernateUtil.getSession();
		List<Stats> statsList = null;
		try {
			statsList = sess.createQuery("FROM Stats").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return statsList;
	}

	@Override
	public Stats getStats(int id) {
		
		Session sess = HibernateUtil.getSession();
		Stats s = null;
	
		try {
			s = (Stats) sess.get(Stats.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return s;
	}

	@Override
	public boolean updateStats(Stats stats) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		boolean success = false;
		
	
		try {
			tx = sess.beginTransaction();
			sess.saveOrUpdate(stats);
			tx.commit();
			success = true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
		return success;
	}

}
