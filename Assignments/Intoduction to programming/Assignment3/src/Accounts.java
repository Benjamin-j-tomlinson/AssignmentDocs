
public class Accounts {

	private String accName;
	private String accType;
	private int accNum;
	private double accBal;

	public Accounts(String accName, String accType, int accNum, double accBal) {

		this.accName = accName;
		this.accType = accType;
		this.accNum = accNum;
		this.accBal = accBal;
	}

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
	public void setaccBal(double changeABal) {
		this.accBal = changeABal;
	}

	public String toString() {
		return String.format("Account Name: %s \n Account Type: %s \n Account Number: %s \n Account Balance: %s", accName, accType, accNum, accBal);
	}

}
