package data;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {
	//Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String lastName;
	private String firstName;
	private int nationalId;
	private LocalDate dateOfBirth;
	private boolean inactive;
	private Contact contact;
	
	// Empty constructor
	public Customer () {}

	// Constructor using fields
	public Customer(String lastName, String firstName, int nationalId, LocalDate dateOfBirth, Contact contact) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.nationalId = nationalId;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
	}

	// Getters and Setters
	public long getCustomerId() {
		return customerId;
	}

	protected void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getNationalId() {
		return nationalId;
	}

	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isInactive() {
		return inactive;
	}

	public void setInactive(boolean inactive) {
		this.inactive = inactive;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
    public String toString() {
        return "\nCustomer\n\t[customerId: " + customerId + "\n\tlastName: " + lastName + "\n\tfirstName: " + firstName
                + "\n\tnationalId: " + nationalId + "\n\tdateOfBirth: " + dateOfBirth + "\n\tinactive: " + inactive + "]";
    }

    public String toStringWithContacts() {
    	String str;
    	if(contact!=null) {
    		str = toString() + contact;
    	}else {
    		str = toString() + "\n\tcontact: "+contact;
    	}
    	 
    	
        return str;
    }
	
	
}	
