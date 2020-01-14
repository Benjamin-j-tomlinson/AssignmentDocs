
public class Customer {
//private member variables including a refrence to the account object

	private int customerNumber;
	private String custFirstName;
	private String custLastName;
	private String custAddress;
	private int contactNum;
	private Accounts account;

	// customer constructor for the variables above including the parameters

	public Customer(int customerNumber, String customerF, String customerL, String customerA, int customerContact,
			Accounts account) {
		this.customerNumber = customerNumber;
		this.custFirstName = customerF;
		this.custLastName = customerL;
		this.custAddress = customerA;
		this.contactNum = customerContact;
		this.account = account;

	}

	// accessor methods
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

//accessor method for the refrence to the account object
	public Accounts getAccounts() {

		return account;
	}

	// mutator method for the account refrence
	public void setAccount(Accounts account2) {
		this.account = account2;
	}

// modified toString method by printing the object as a string with declaring variable positions with the %s and variables at the end
	
	public String toString() {
		return String.format(
				"\n Customer number: %s \n Customer first name: %s \n Customer last name: %s \n Customer Address: %s \n Contact number: %s \n \n %s \n ",
				customerNumber, custFirstName, custLastName, custAddress, contactNum, account);
	}

}
