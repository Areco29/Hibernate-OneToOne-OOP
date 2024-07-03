package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Contact;

public class ContactDAO {
	
	private Session session;
	private Transaction tx;
	
	private void beginOperation() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void handleException(HibernateException he) throws HibernateException {
		
		tx.rollback();
		throw new HibernateException("\nError in Data Access Object\n",he);
		
	}
	
	
	public int addContact(Contact c) {
		int id = 0;
		
		try {
			beginOperation();
			id = Integer.parseInt(session.save(c).toString());
			tx.commit();
		}catch(HibernateException he) {
			handleException(he);
			throw he;
		}finally {
			session.close();
		}
		
		return id;
	}
	
	public void deleteContact(Contact c) {
		
		try {
			beginOperation();
			session.delete(c);
			tx.commit();
		}catch(HibernateException he) {
			handleException(he);
			throw he;
		}finally {
			session.close();
		}
		
	}
	
	
	public void updateContact(Contact c) {
		
		try {
			beginOperation();
			session.update(c);
			tx.commit();
		}catch(HibernateException he) {
			handleException(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	
	public Contact retrieveContact(long contactId) {
		Contact contact = null;
		
		try {
			beginOperation();
			contact = session.get(Contact.class, contactId);
			
		}finally {
			session.close();
		}
		
		return contact;
	}
	
	
	
	public Contact retrieveContact(String mobile ) {
		
		Contact c = null;
		
		try {
			beginOperation();
			c = session.createQuery("from Contact c where c.mobile = :mobile",Contact.class)
					.setParameter("mobile", mobile)
					.uniqueResult();
		}finally {
			session.close();
		}
		
		return c;
	}
	
	public List<Contact> retrieveContact(){
		List<Contact> list = new ArrayList<Contact>();
		
		try {
			beginOperation();
			list = session.createQuery("from Contact",Contact.class).getResultList();
			
		}finally {
			session.close();
		}
		
		return list;
	}
}











