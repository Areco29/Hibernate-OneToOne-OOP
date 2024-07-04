package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Customer;

public class CustomerDAO {
	
	private Session session;
	private Transaction tx;
	
	private void beginOperation() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	
	private void handleException(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("\nError in Data Access Object\n",he);
	}
	
	
	public int addCustomer(Customer c) {
		
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
	
	public Customer retrieveCustomer(long idCustomer) {
		
		Customer customer = null;
		
		try {
			
			beginOperation();
			customer = session.get(Customer.class, idCustomer);
			
		}finally {
			session.close();
		}
		
		return customer;
	}
	
	public void updateCustomer(Customer customer) {
		
		try {
			
			beginOperation();
			session.update(customer);
			tx.commit();
			
		}catch(HibernateException he) {
			handleException(he);
			throw he;
		}finally {
			session.close();
		}
		
	}
	
	
	
	public void deleteCustomer(Customer customer) {
		
		try {
			
			beginOperation();
			session.delete(customer);
			tx.commit();
			
		}catch(HibernateException he) {
			handleException(he);
			throw he;
		}finally {
			session.close();
		}
		
	}
	
	public List<Customer> retrieveCustomer(){
		List<Customer> list = new ArrayList<Customer>();
		
		try {
			beginOperation();
			list = session.createQuery("from Customer c order by c.lastName asc, c.firstName asc",Customer.class).getResultList();
		}finally {
			session.close();
		}
		
		return list;
	}
	
	public Customer retrieveCustomer(int nationalId) {
		Customer customer = null;
		
		try {
			beginOperation();
			customer = session.createQuery("from Customer c where c.nationalId = :nationalId order by c.lastName asc, c.firstName asc ",Customer.class)
					.setParameter("nationalId", nationalId).uniqueResult();
		}finally {
			session.close();
		}
		
		return customer;
	}
}



