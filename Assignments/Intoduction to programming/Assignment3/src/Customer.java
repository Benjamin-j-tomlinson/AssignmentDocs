
public class Customer {

	private int customerNumber;
	private String custFirstName;
	private String custLastName;
	private String custAddress;
	private int contactNum;
	private Accounts account;

	public Customer(int customerNumber, String customerF, String customerL, String customerA, int customerContact,
			Accounts account) {
		this.customerNumber = customerNumber;
		this.custFirstName = customerF;
		this.custLastName = customerL;
		this.custAddress = customerA;
		this.contactNum = customerContact;
		this.account = account;

	}
	


	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public String getCustFirst() {
		return this.custFirstName;
	}

	public String getCustLast() {
		return this.custLastName;
	}

	public String getCustAdd() {
		return this.custAddress;
	}

	public int getContactNum() {
		return this.contactNum;
	}


	public Accounts getAccounts() {

		return account;
	}
	
	public void setAccount(Accounts account2) {
		this.account = account2;
	}

	public String toString() {
		return  String.format("Customer Number: %s \n Customer first name: %s \n Customer last name: %s \n Customer Address: %s \n Contact Number: %s \n \n %s" , customerNumber, custFirstName, custLastName, custAddress, contactNum, account);
	}

}
