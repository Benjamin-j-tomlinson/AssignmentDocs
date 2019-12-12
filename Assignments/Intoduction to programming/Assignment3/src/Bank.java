
public class Bank {

	private int customerNumberRecord;
	private Accounts accounts;
	private Customer customer;

	public Bank(int currentBank, Accounts account, Customer customerRecords) {

		this.customerNumberRecord = currentBank;
		this.accounts = account;
		this.customer = customerRecords;
	}

	public Accounts getAccount() {
		return accounts;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public int getcustomerNumberRecord() {
		return customerNumberRecord;
	}
	


	public String toString() {
		return String.format("\n" + "Customer: " + customerNumberRecord + "\n\n" + customer + "\n");
	}

}
