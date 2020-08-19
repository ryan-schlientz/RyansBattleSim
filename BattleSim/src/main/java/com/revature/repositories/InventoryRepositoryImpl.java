package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Creature;
import com.revature.models.Inventory;
import com.revature.util.HibernateUtil;

public class InventoryRepositoryImpl implements InventoryRepository {

	public int addInventory(Inventory inv) {
		Session sess = HibernateUtil.getSession();
		 int id = 0;
	        try {
	            sess.beginTransaction();
	            id = Integer.parseInt(sess.save(inv).toString());
	            sess.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            sess.getTransaction().rollback();
	        } finally {
	            sess.close();
	        }
		return id;
	}

	public List<Inventory> getAllInventories() {
		Session sess = HibernateUtil.getSession();
		 List<Inventory> list = null;
	        try {
	           list = sess.createQuery("FROM INVENTORY").list();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return list;
	}

	public Inventory getInventory(int id) {
		Session sess = HibernateUtil.getSession();
		 Inventory inv = null;
	        try {
	        	inv = (Inventory) sess.get(Inventory.class, id);
	           
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            sess.close();
	        }
		return inv;
	}

	public void updateInventory(Inventory inv) {
		Session sess = HibernateUtil.getSession();
        try {
            sess.beginTransaction();
            sess.merge(inv);
            sess.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            sess.getTransaction().rollback();
        } finally {
            sess.close();
        }

	}

	public void deleteInventory(int i_id) {
		Session sess = HibernateUtil.getSession();
        try {
            sess.beginTransaction();
            sess.delete(sess.get(Inventory.class, i_id));
            sess.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            sess.getTransaction().rollback();
        } finally {
            sess.close();
        }

	}

}
