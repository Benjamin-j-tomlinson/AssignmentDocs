
//Specific import statements to be able to use the buffered file reader

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//Specific import statement for the JOptionPane
import javax.swing.JOptionPane;

//Public class, application class
public class BankRecord {
//Class member variables declared private so no outside classes can access them 
	// unless a getter or setter is used
	// 3 objects are instantiated to arrays
	// numcustomers is the variable to instantiate the objects with the length
	// of this variable
	private int numCustomers;
	// Bank class and instantiate a bank object as an array
	private Bank[] bank;
	// Customer class and instantiate a Customer object as an array
	private Customer[] customerRecords;
	// Accounts class and instantiate an account object as an array
	private Accounts[] account;
	private int currentCustomer;
	private int currentAccount;
	private int currentBank;

	public BankRecord() {
// constructor, setting limit of object lengths with numCustomers
		this.numCustomers = 3;
		this.bank = new Bank[numCustomers];
		this.customerRecords = new Customer[numCustomers];
		this.account = new Accounts[numCustomers];
		// These variables are used to iterate through each array without using a
		// single variable and resetting
		this.currentCustomer = 0;
		this.currentAccount = 0;
		this.currentBank = 0;
		loadAccount();
		// Call show menu method
		showMenu();
	}

	public void loadAccount() {
		// creating buffered reader
		BufferedReader file_name = null;
		// try and catch block
		try {
			// assigning file account to new filereader to new buffered reader into the
			// filename variable
			file_name = new BufferedReader(new FileReader("account.csv"));
			// storing readLine in a string variable, read line reads line by line
			String var_name = file_name.readLine();
			// while the result of the readline is not nothing meaning there is something
			while (var_name != null) {
				// creating a string array with split values seperated by a comma and each is
				// stored within a seperate index
				String[] variable_name2 = var_name.split(",");

				// create new objects with the values from the index, use parse int and double
				// to convert the values from a string to the right
				// data types
				this.account[currentAccount] = new Accounts(variable_name2[1], variable_name2[2],
						Integer.parseInt(variable_name2[3]), Double.parseDouble(variable_name2[4]));
				this.customerRecords[currentCustomer] = new Customer(Integer.parseInt(variable_name2[5]),
						variable_name2[6], variable_name2[7], variable_name2[8], Integer.parseInt(variable_name2[9]),
						account[currentAccount]);
				this.bank[this.currentBank] = new Bank(Integer.parseInt(variable_name2[0]), account[currentAccount],
						customerRecords[currentCustomer]);
				this.currentBank += 1;
				this.currentAccount += 1;
				this.currentCustomer += 1;
				// read another line to fulfill the condition in the loop until there is no line
				// left in the document
				var_name = file_name.readLine();
			}

			// close the file
			file_name.close();
			// if the file read fails generate message
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// I would have used the bufferedfile reader but as this can only be used with
	// Strings i would have to use another method of getting integers and strings
	// from a single line
	// or through multiple lines
	public void saveAccount() {
		// Save account method uses a buffered file writer
		// Creating the bufferedwriter and assigning to file_name with a
		// value of null
		BufferedWriter file_name1 = null;
		try {
			// Try block, assigning filewriter to a buffered writer with the file
			file_name1 = new BufferedWriter(new FileWriter("account.csv"));
			int varName = 0;
			int i = 0;
			// Loop through until var_name is equal to currentBank
			while (varName <= this.currentBank) {
				// write the get methods from bank object at specific index
				file_name1.write(bank[i].getcustomerNumberRecord() + "," + account[i].getaccName() + ","
						+ account[i].getaccType() + "," + account[i].getaccNum() + "," + account[i].getaccBal() + ","
						+ customerRecords[i].getCustomerNumber() + "," + customerRecords[i].getCustFirst() + ","
						+ customerRecords[i].getCustLast() + "," + customerRecords[i].getCustAdd() + ","
						+ customerRecords[i].getContactNum() + "\n");
				varName++;
				i += 1;
			}
			// close the buffered reader
			file_name1.close();
// if an error (exception) is caught if the try block fails
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void showMenu() {
		// Menu from a string with each line add this sentence
		String menu = "";
		menu += "1. Add Account" + "\n";
		menu += "2. Add Customer" + "\n";
		menu += "3. Change customer balance" + "\n";
		menu += "4. Finalise current records" + "\n";
		menu += "5. View previous records" + "\n";
		String choice = JOptionPane.showInputDialog(menu);
// passing the value of the string to an int datatype this is to compare
		// the input and call the appropriate method.
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
		if (menuOption > 5 || menuOption < 0) {
			// If the user enters a value outside the range of menu options
			// it will display an error message
			JOptionPane.showMessageDialog(null, "Invalid choice! Try again");
			choice = JOptionPane.showInputDialog(menu);
		}

	}

	public void expand() {
		// this is used to expand the amount of input the program will accept
		// If the amount of customers or accounts is greater than or equal to
		// numcustomers it will double the amount of space in the arrays and the
		// variable numcustomers
		if (currentCustomer >= numCustomers || currentAccount >= numCustomers) {
			// sets the length of new object to twice that of numcustomers
			// sets the length of the following objects to the previous
			// object lengths
			Bank[] newBank = new Bank[numCustomers * 2];
			Customer[] newCustomer = new Customer[newBank.length];
			Accounts[] newAccount = new Accounts[newCustomer.length];

			int i = 0;
			while (i < numCustomers) {
				// while 0 is less than numcustomers copy the values from
				// each index of the object and pass them to the new objects
				// with each pass of the while loop
				newBank[i] = bank[i];
				newCustomer[i] = customerRecords[i];
				newAccount[i] = account[i];
				i += 1;
			}
			// set the previous object references to the new values from the new
			// references including the new length
			bank = newBank;
			customerRecords = newCustomer;
			account = newAccount;
			// set the variable numcustomers to the new length for when this method is
			// called it will have the updated value to double effectively incrementally
			// increasing.
			this.numCustomers = newAccount.length;
		}
	}

	public void checkObject() {
		// with the program if this code is not in place the user would be able
		// to enter a customer then account, if this happens it will display null
		// in order to prevent that this code block, retrieves the difference between
		// the objects, sets the customer object to the previous still containing the
		// values,
		// this then sets the current customer object with the values from the new
		// account and setting its account reference to the matching account
		// afterwards both indexes increase unless the method gets called again
		// this will only occur if the amount of customers is greater than the accounts
		// and will effectively decrease the gap with every call until both are matching
		int i = currentCustomer - currentAccount;
		currentCustomer -= i;
		customerRecords[currentCustomer].setAccount(account[currentAccount]);
		currentCustomer += i;

	}

	public void addBankAccount() {

		// call the expand method to check the value of current account and expand if
		// necessary
		expand();

		// Storing variables with user input to get the account details
		String accName = JOptionPane.showInputDialog(null, "Enter customer account name");
		String accType = JOptionPane.showInputDialog(null, "Enter customer account type");
		int accNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Customer account number"));
		double accBal = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter customer account balance"));
		// sets the values from the variables to the current account object and then
		// increment
		this.account[this.currentAccount] = new Accounts(accName, accType, accNum, accBal);
		// if the user had entered customers before accounts call the checkobject method
		// to rectify
		// otherwise when the user has finished it will display null
		if (currentCustomer > currentAccount) {
			checkObject();
		}
		// increment the currentaccount
		this.currentAccount += 1;

		showMenu();

	}

	public void addCustomer() {

		expand();
// this is the same with the top method except for using the account object and passing it to 
		// this object as an argument this is to create a has a relationship
		// (composition) where
		// where customers have a bank account
		int customerNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer number"));
		String customerF = JOptionPane.showInputDialog(null, "Enter customer first name");
		String customerL = JOptionPane.showInputDialog(null, "Enter customer last name");
		String customerA = JOptionPane.showInputDialog(null, "Enter customer address");
		int customerContact = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter customer contact number"));
		this.customerRecords[this.currentCustomer] = new Customer(customerNumber, customerF, customerL, customerA,
				customerContact, account[currentCustomer]);
		currentCustomer += 1;

// do not need to call check object because if the account is greater the previous instances will be set to the customer object

		this.customerRecords[this.currentCustomer] = new Customer(customerNumber, customerF, customerL, customerA,
				customerContact, account[currentCustomer]);

		showMenu();

	}

	public void changeCustomerBal() {
		if (currentBank == 0) {
			// currentBank is the counter for the bank class and if there are no completed
			// bank objects display the following
			JOptionPane.showMessageDialog(null,
					"You must finalise the account before you can change the account balance by selecting Finalise in the menu");
			showMenu();
		}
		int i = 0;
		// because the bank objects are complete customer objects have account
		// objects
		// Enter the customer who balance you need to change
		String record = " ";
		if (currentBank > 1) {
			record = "records";
		} else {
			record = "record";
		}
		int changeBalance = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Enter Customer record number to change balance, there is a total of " + currentBank + " " + record));
		// if the user has finalised previous records but not the current ones the user
		// will not be able to access the current
		// ones until they have because they wont exist
		if (currentCustomer > currentBank) {
			JOptionPane.showMessageDialog(null, "You can only access" + currentBank + " unless the remaining \n"
					+ (currentCustomer - currentBank) + " are finalised");
		}

		// if the user enters input less than 0 and greater than the existing objects
		// display the message
		while (changeBalance < 0 || changeBalance > currentBank + 1) {
			JOptionPane.showMessageDialog(null, "Error!, customer does not exist!");
			changeBalance = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Enter Customer number to change balance between 0 and " + currentBank));
		}
		// check to see if there is a value matching the record specified and if it does
		// set the account object
		// specific to the number i and change the value through mutator method in the
		// account class
		while (i < currentBank) {
			if ((bank[i].getcustomerNumberRecord() == changeBalance)) {
				double changeABal = Double
						.parseDouble(JOptionPane.showInputDialog(null, "Enter the new amount for: " + changeBalance));
				account[i].setaccBal(changeABal);
				System.out.println(bank[i]);

			}
			i += 1;
		}
		showMenu();
	}

	public void total() {
		// These conditional if statements check if the current account, customer are
		// greater than 0 or if there is
		// a part missing for instance an account with no customer
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
// if the customer counter is greater than the finalised bank create a new bank object based on the customer and account objects
		// The bank has a composite relationship with customer and account as a bank has
		// both of these
		while (currentCustomer > currentBank) {

			this.bank[this.currentBank] = new Bank(this.currentBank, this.account[currentBank],
					this.customerRecords[currentBank]);

			JOptionPane.showMessageDialog(null, bank[currentBank]);
			saveAccount();
			this.currentBank += 1;
		}

		showMenu();
	}

	public void previousRecords() {
		// check if there are no finalised records and display they aren't
		// if there is, loop through to find each bank reference to the bank object
		// display each message incrementally

		int i = 0;
		if (currentBank == 0) {
			JOptionPane.showMessageDialog(null, "Opps! there are no finalised records");
			showMenu();
		}
		while (i < currentBank) {
			JOptionPane.showMessageDialog(null, bank[i]);
			i += 1;
		}
		showMenu();
	}

	public static void main(String[] args) {

		// create a new assignment for new assignment object refrence and assign to
		// reference variable
		// bank

		BankRecord bank = new BankRecord();
	}

}
