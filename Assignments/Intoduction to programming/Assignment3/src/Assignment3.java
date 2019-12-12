import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Assignment3 {

	private int numCustomers;
	private Bank[] bank;
	private Customer[] customerRecords;
	private Accounts[] account;
	private int currentCustomer;
	private int currentAccount;
	private int currentBank;

	public Assignment3() {

		this.numCustomers = 2;
		this.bank = new Bank[numCustomers];
		this.customerRecords = new Customer[numCustomers];
		this.account = new Accounts[numCustomers];
		this.currentCustomer = 0;
		this.currentAccount = 0;
		this.currentBank = 0;
//		loadAccount();
		showMenu();
	}

//	public void loadAccount() {
//		BufferedReader file_name = null;
//		int variable_name1;
//		try {
//			file_name = new BufferedReader(new FileReader("C:/Users/Ben/eclipse-workspace/account.csv"));
//			variable_name1 = 0;
//			String var_name = file_name.readLine();
//			while (var_name != null) {
//				String[] variable_name2 = var_name.split(",");
//
//				if (this.currentCustomer < this.numCustomers) {
//
//					this.bank[this.currentBank] = new Bank(bank[0], account[1], customerRecords[2]);
//					this.currentBank += 1;
//				}
//				var_name = file_name.readLine();
//			}
//			file_name.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}

	public void saveAccount() {
		BufferedWriter file_name1 = null;
		try {
			file_name1 = new BufferedWriter(new FileWriter("C:/Users/Ben/eclipse-workspace/account.csv"));
			int varName = 0;
			int i = 0;
			while (varName < this.currentBank) {
				file_name1.write(bank[i].toString());
				varName++;
				i += 1;
			}
			file_name1.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void showMenu() {
		String menu = "";
		menu += "1. Add Account" + "\n";
		menu += "2. Add Customer" + "\n";
		menu += "3. Change customer balance" + "\n";
		menu += "4. Finalise current records" + "\n";
		menu += "5. View previous records" + "\n";
		String choice = JOptionPane.showInputDialog(menu);

		int menuOption = Integer.parseInt(choice);
		if (menuOption == 1) {
			addBankAccount();
		}
		if (menuOption == 2) {
			addCustomer();
		}
		if (menuOption == 3) {
			changeCustomerBal();
		}
		if (menuOption == 4) {
			total();
		}
		if (menuOption == 5) {
			previousRecords();
		}
		if (menuOption > 4 || menuOption < 0) {
			JOptionPane.showMessageDialog(null, "Invalid choice! Try again");
			choice = JOptionPane.showInputDialog(menu);
		}

	}

	public void expand() {
		if (currentCustomer >= numCustomers || currentAccount >= numCustomers) {
			Bank[] newBank = new Bank[numCustomers * 2];
			Customer[] newCustomer = new Customer[newBank.length];
			Accounts[] newAccount = new Accounts[newCustomer.length];

			int i = 0;
			while (i < numCustomers) {
				newBank[i] = bank[i];
				newCustomer[i] = customerRecords[i];
				newAccount[i] = account[i];
				i += 1;
			}

			bank = newBank;
			customerRecords = newCustomer;
			account = newAccount;
			this.numCustomers = newAccount.length;
		}
	}

	public void checkObject() {
		int i = currentCustomer - currentAccount;
		currentCustomer -= i;
		customerRecords[currentCustomer].setAccount(account[currentAccount]);
		currentCustomer += i;

	}

	public void addBankAccount() {
		int i = 0;
		expand();

		if (i < numCustomers) {

			String accName = JOptionPane.showInputDialog(null, "Enter customer account name");
			String accType = JOptionPane.showInputDialog(null, "Enter customer account type");
			int accNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Customer account number"));
			double accBal = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter customer account balance"));
			this.account[this.currentAccount] = new Accounts(accName, accType, accNum, accBal);
			if (currentCustomer > currentAccount) {
				checkObject();
			}
			this.currentAccount += 1;

		}
		showMenu();

	}

	public void addCustomer() {
		int i = 0;
		expand();

		if (i < numCustomers) {
			int customerNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer number"));
			String customerF = JOptionPane.showInputDialog(null, "Enter customer first name");
			String customerL = JOptionPane.showInputDialog(null, "Enter customer last name");
			String customerA = JOptionPane.showInputDialog(null, "Enter customer address");
			int customerContact = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer contact number"));
			this.customerRecords[this.currentCustomer] = new Customer(customerNumber, customerF, customerL, customerA,
					customerContact, account[currentCustomer]);
			currentCustomer += 1;

			if (currentAccount > currentCustomer) {

				this.customerRecords[this.currentCustomer] = new Customer(customerNumber, customerF, customerL,
						customerA, customerContact, account[currentCustomer]);
			}

		}

		showMenu();

	}

	public void changeCustomerBal() {
		if (currentBank == 0) {
			JOptionPane.showMessageDialog(null,
					"You must finalise the account before you can change the account balance by selecting Finalise in the menu");
			showMenu();
		}
		int i = 0;
		while (i < customerRecords.length) {

	
			int changeBalance = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Enter Customer record number to change balance, there are a total of " + currentBank + " records"));

			if (currentCustomer > currentBank) {
				JOptionPane.showMessageDialog(null, "but you can only access" + currentBank + " unless the remaining \n"
						+ +currentCustomer + "are finalised");
			}

			while (changeBalance < 0 || changeBalance > currentCustomer + 1) {
				JOptionPane.showMessageDialog(null, "Error!, customer does not exist!");
				changeBalance = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter Customer number to change balance between 0 and " + currentCustomer));
			}
			i = 0;
			while (i < currentBank) {
				if ((bank[i].getcustomerNumberRecord() == changeBalance)) {
					double changeABal = Double.parseDouble(
							JOptionPane.showInputDialog(null, "Enter the new amount for: " + changeBalance));
					account[i].setaccBal(changeABal);
					System.out.println(bank[i]);
				}
				i += 1;
			}
		}
	}

	public void total() {
		if (currentCustomer == 0 || currentAccount == 0) {
			JOptionPane.showMessageDialog(null, "Error, you must add both a customer and account");
			showMenu();
		}

		if (currentAccount > currentCustomer) {
			JOptionPane.showMessageDialog(null, "Error, you need to enter a customer for account:  " + currentCustomer);
			showMenu();
		}
		if (this.currentCustomer > this.currentAccount) {
			JOptionPane.showMessageDialog(null, "Error, you need to enter an account for customer:  " + currentAccount);
			showMenu();
		}

		while (currentCustomer > currentBank) {

			this.bank[this.currentBank] = new Bank(this.currentBank, this.account[currentBank],
					this.customerRecords[currentBank]);

			JOptionPane.showMessageDialog(null, bank[currentBank]);

			this.currentBank += 1;
		}
		saveAccount();
		showMenu();
	}
	
	public void previousRecords() {
		int i = 0;
		while (i < currentBank) {
			JOptionPane.showMessageDialog(null, bank[i]);
			i += 1;
		}
	}

	public static void main(String[] args) {

		Assignment3 bank = new Assignment3();
	}

}
