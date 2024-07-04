package data;

public class Contact {
	
	//Attributes
	private long contactId;
	private String email;
	private String mobile;
	private String phone;
	private Customer customer;
	
	// Empty constructor
	public Contact() {}

	// Constructor using fields
	public Contact( String email, String mobile, String phone, Customer customer) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.customer = customer;
	}

	// Getters and Setters
	public long getContactId() {
		return contactId;
	}

	protected void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// Override toString method
	@Override
	public String toString() {
		return "\n\tContact:\n\t\tcontactId: " + contactId + "\n\t\temail: " + email + "\n\t\tmobile: " + mobile + "\n\t\tphone: " + phone;
	}
	
	
}
