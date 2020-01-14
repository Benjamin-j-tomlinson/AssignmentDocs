
public class Bank {
	// Private variables including refrences to the account and customer
	// this is a "has-a" relationship
	private int customerNumberRecord;
	private Accounts accounts;
	private Customer customer;

	// bank constructor with parameters for object references and total records
	public Bank(int customerNumberRecord, Accounts account, Customer customerRecords) {

		this.customerNumberRecord = customerNumberRecord;
		this.accounts = account;
		this.customer = customerRecords;
	}

	// accessor methods for private variables including return type of
	// object
	public Accounts getAccount() {
		return accounts;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getcustomerNumberRecord() {
		return customerNumberRecord;
	}

	// modified toString method to format output as a string and place holders for
	// variable values

	public String toString() {
		return String.format("Customer record number: %s \n \n Customer account details: %s \n", customerNumberRecord, customer);
	}

}
