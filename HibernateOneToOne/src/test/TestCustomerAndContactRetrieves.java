package test;

import java.util.List;

import data.Contact;
import data.Customer;
import service.ContactService;
import service.CustomerService;

public class TestCustomerAndContactRetrieves {

	public static void main(String[] args) {
		
		
		System.out.println("\nTest for Customer and Contacts retrieves.\n");

		CustomerService customerService = new CustomerService();
        ContactService contactService = new ContactService();
        
        // Show all customers from database without contacts
        System.out.println("All customers from database (without contacts):\n");
        
        List<Customer> listCustomer = customerService.retrieveCustomer();
        for (Customer c : listCustomer) {
            System.out.println(c.toString());
        }
        
        System.out.println("\n======================================\n");
        
        // Show all customers from database with contacts
        System.out.println("All customers from database (with contacts):\n");
        
        for (Customer c : listCustomer) {
            System.out.println(c.toStringWithContacts());
        }
        
        System.out.println("\n======================================\n");
        
        // Show all contacts from database
        System.out.println("All contacts from database:\n");
        
        List<Contact> listContact = contactService.retrieveContact();
        for (Contact contact : listContact) {
            System.out.println(contact.toString());
        }
	}

}
