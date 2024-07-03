package service;

import java.time.LocalDate;
import java.util.List;

import dao.CustomerDAO;
import data.Contact;
import data.Customer;

public class CustomerService {
	CustomerDAO dao = new CustomerDAO();
	
	public int addCustomer(String lastName, String firstName, int nationalId, LocalDate dateOfBirth, Contact contact) throws Exception {
		
		if(dao.retrieveCustomer(nationalId)!=null) throw new Exception("\nError in CustomerService.addCustomer: Another customer with the same nationalId already exist.\n");
		
		return dao.addCustomer(new Customer( lastName, firstName, nationalId, dateOfBirth, contact));
		
	}
	
	public Customer retrieveCustomer(long idCustomer) {
		return dao.retrieveCustomer(idCustomer);
	}
	
	
	public void updateCustomer(Customer customer) throws Exception {
		
		if(dao.retrieveCustomer(customer.getNationalId())!=null) throw new Exception("\nError in CustomerService.addCustomer: Another customer with the same nationalId already exists.\n");
		
		dao.updateCustomer(customer);
		
	}
	
	public void deleteCustomer(long idCustomer) throws Exception {
		Customer c = dao.retrieveCustomer(idCustomer);
		
		if(c==null) throw new Exception("\nError in CustomerService.deleteCustomer: Customer doesn't exist.\n");
		
		dao.deleteCustomer(c);
		
	}
	
	public List<Customer> retrieveCustomer(){
		
		return dao.retrieveCustomer();
		
	}
	
	public Customer retrieveCustomer(int nationalId) {
		return dao.retrieveCustomer(nationalId);
	}
	
}















