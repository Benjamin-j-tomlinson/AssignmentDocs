
public class Accounts {
//private member variables for the Accounts class
	private String accName;
	private String accType;
	private int accNum;
	private double accBal;

//constructor for the accounts class including parameters to accept arguments for instantiation
	public Accounts(String accName, String accType, int accNum, double accBal) {

		this.accName = accName;
		this.accType = accType;
		this.accNum = accNum;
		this.accBal = accBal;
	}

//accessor methods to return variables
	public String getaccName() {
		return this.accName;
	}

	public String getaccType() {
		return this.accType;
	}

	public int getaccNum() {
		return this.accNum;
	}

	public double getaccBal() {
		return this.accBal;
	}

	// mutator method to change the account balance
	public void setaccBal(double changeABal) {
		this.accBal = changeABal;
	}

	// modified toString to format the result as an object with place holders for
	// string %s signaling lower case and variables used are at the end of the
	// expression

	public String toString() {
		return String.format("Account name: %s \n Account Type: %s \n Account number: %s \n Account balance: %s",
				accName, accType, accNum, accBal);
	}

}
