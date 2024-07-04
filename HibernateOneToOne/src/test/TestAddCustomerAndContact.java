package test;

import java.time.LocalDate;
import java.util.List;

import data.Customer;
import service.ContactService;
import service.CustomerService;

public class TestAddCustomerAndContact {

    public static void main(String[] args) {
        System.out.println("\nTesting Add method for customers\n");
        CustomerService customerService = new CustomerService();
        
        // Retrieve and show all current customers from database
        List<Customer> listCustomers = customerService.retrieveCustomer();
        
        System.out.println("\nCustomers in database\n");
        for(Customer c : listCustomers) {
            System.out.println(c.toStringWithContacts());
        }
        
        System.out.println("\n===========================================\n");
        
        // Add a new customer to the database
        try {
            customerService.addCustomer("Areco", "Pablo", 44252210, LocalDate.of(2000, 3, 5), null);
            System.out.println("Customer added.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n===========================================\n");
        
        // Retrieve and show all current customers from database after adding a customer
        listCustomers = customerService.retrieveCustomer();

        System.out.println("\nCustomers in database with new customer\n");
        for(Customer c : listCustomers) {
            System.out.println(c.toStringWithContacts());
        }
        
        System.out.println("\n===========================================\n");

        System.out.println("\nTesting Add method for contacts\n");
        
        ContactService contactService = new ContactService();
        
        // Add a new contact to a customer
        try {
            contactService.addContact("arecopablo@gmail.com", "15-1234-5678", "11-1234-5678", customerService.retrieveCustomer(4L));
            System.out.println("Contact added.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n===========================================\n");
        
        // Retrieve and show all contacts customers from database after adding a customer
        listCustomers = customerService.retrieveCustomer();

        System.out.println("\nCustomers in database with new contact added\n");
        for(Customer c : listCustomers) {
            System.out.println(c.toStringWithContacts());
        }
    }
}

