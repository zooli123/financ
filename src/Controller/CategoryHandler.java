package Controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Category;

public class CategoryHandler {
	private static SessionFactory factory;
	
	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory factory) {
		CategoryHandler.factory = factory;
	}

	public void createFactory(){
	 try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
	}
	 
	 public Integer addCategory(String name, boolean positive){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer categoryID = null;
	      try{
	         tx = session.beginTransaction();
	         Category category = new Category(name, positive);
	         categoryID = (Integer) session.save(category); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return categoryID;
	   }
	   /* Method to  READ all the employees */
	   public void listCategories( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List categories = session.createQuery("FROM Category").list(); 
	         for (Iterator iterator = 
	                           categories.iterator(); iterator.hasNext();){
	            Category category = (Category) iterator.next(); 
	            System.out.println("Name: " + category.getName()); 
	            System.out.println("Positive: " + category.isPositive()); 
	            System.out.println();
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
}
