package service;

import java.util.List;

import dao.ContactDAO;
import data.Contact;
import data.Customer;

public class ContactService {
	
	ContactDAO dao = new ContactDAO();
	
	public int addContact( String email, String mobile, String phone, Customer customer) throws Exception {
		
		if(customer.getContact()!=null) throw new Exception("\nError in ContactService.addContact: This customer already has a contact.\n");
		
		return dao.addContact(new Contact(email,  mobile,  phone,  customer));
	}
	
	public void deleteContact(long contactId) throws Exception {
		
		Contact c = dao.retrieveContact(contactId);
		
		if(c==null) throw new Exception("\nError in ContactService.deleteContact: The contact to delete doesn't exist.\n");
		
		dao.deleteContact(c);
	}
	
	public void updateContact(Contact c) throws Exception {
		
		if(dao.retrieveContact(c.getMobile())!=null) throw new Exception("\nError in ContactService.updateContact: Another contact with same mobile number already exists.\n");
		
		dao.updateContact(c);
	}
	
	
	public Contact retrieveContact(long contactId) {
		return retrieveContact(contactId);
	}
	
	public Contact retrieveContact(String mobile) {
		return dao.retrieveContact(mobile);
	}
	
	public List<Contact> retrieveContact(){
		return dao.retrieveContact();
	}
}
