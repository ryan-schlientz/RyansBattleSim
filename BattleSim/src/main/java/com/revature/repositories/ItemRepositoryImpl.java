package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Item;
import com.revature.util.HibernateUtil;

public class ItemRepositoryImpl implements ItemRepository {

	@Override
	public int addItem(Item item) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = sess.beginTransaction();
			id = Integer.parseInt(sess.save(item).toString());
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
	public List<Item> getAllItems() {
		Session sess = HibernateUtil.getSession();
		List<Item> itemlist = null;
		try {
			itemlist = sess.createQuery("FROM Item").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return itemlist;
	}

	@Override
	public Item getItem(int id) {
		Session sess = HibernateUtil.getSession();
		Item s = null;
	
		try {
			s = (Item) sess.get(Item.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return s;
	}

	@Override
	public boolean updateItem(Item item) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		boolean success = false;
		
	
		try {
			tx = sess.beginTransaction();
			sess.saveOrUpdate(item);
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
	
	@Override
	public boolean deleteItem(Item item) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		boolean success = false;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(item);
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
