import javax.swing.JOptionPane;

public class GuessingGame {

	public static void main(String[] args) {
		// Create a new object instance called guess and call the gameMenu method to run
		// the program
		GuessingGame guess = new GuessingGame();
		guess.gameMenu();

	}

	// Integer variable yesOrNo is used to store a 1 and if user enters any other
	// value the program will terminate
	public void gameMenu() {

// creating a string menu with options for user to choose
		int lives = 0, genRanNumber = 0, menuChoice = 0;
		String menu = "";
		menu += "Would you like to play a guessing game?\n";
		menu += "1. Yes \n";
		menu += "2. No \n";
		// store value in yesOrNo an parse string to integer menuChoice and check and
		// either initiate or terminate program.
		String yesOrNo = JOptionPane.showInputDialog(menu);

		// declaring and initialising lives and genRanNumber integer vairables

		menuChoice = Integer.parseInt(yesOrNo);
		if (menuChoice == 1) {
			// if user says yes then pass lives and genRanNumber into userGuesses method
			userGuesses(lives, genRanNumber);

		}
		// if user says no terminate program with goodbye message
		else if (menuChoice == 2) {
			JOptionPane.showMessageDialog(null, "GoodBye");
			yesOrNo = null;
		} else {
			JOptionPane.showMessageDialog(null, "Invalid choice!");
			yesOrNo = JOptionPane.showInputDialog(menu);
		}
	}

	// Generate random number from 0 to 1 and times 100 to get a number between 0
	// and 100 then round to integer with math floor
	// receive an argument and pass to random, complete computation and return
	public double generateRandomNumber(double random) {
		// return random value
		return random = Math.floor((Math.random() * ((100))));

	}

	// userGuesses method, receive arguments from game menu

	public int generateLives(int lives) {
		// create object to store choices for custom dialog
		// set lives based on the choice the user makes and returns the value.
		Object[] choice = { "Easy", "Difficult", "Hard" };
		int difficulty = JOptionPane.showOptionDialog(null, "Do you want it to be difficult or easy?", "Difficulty",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, choice, null);
		if (difficulty == 0) {
			JOptionPane.showMessageDialog(null, "You have chosen Easy");
			lives = 8;
		}

		else if (difficulty == 1) {
			JOptionPane.showMessageDialog(null, "You have chosen Difficult");
			lives = 5;
		} else {
			JOptionPane.showMessageDialog(null, "You have chosen Hard");
			lives = 3;

		}
		return lives;
	}

	public void userGuesses(int lives, int genRanNumber) {

		// create and initialize integer array with null
		int[] totalGuesses = null;
		// call method to generate lives for user and pass to the user lives variables
		int userLives = generateLives(lives);
		// set the totalguesses array length to the userlives integer
		totalGuesses = new int[userLives];
		// generate random number and set to integer randomnumber by calling
		// generaterandomnumber and passing an argument
		double randomNumber = 0;
		randomNumber = generateRandomNumber(genRanNumber);
		// declaring and initializing current guesses and guess to 0
		int currentGuesses = 0;
		int guess = 0;
		System.out.println(randomNumber);
		// notify user what they have to do by showing a dialog message
		JOptionPane.showMessageDialog(null,
				"You have " + userLives + " lives and to guess the correct number between 0 and 100 ");
		// while user lives is greater than 0
		while (userLives > currentGuesses) {
			// prompt user to enter a guess
			guess = Integer.parseInt(JOptionPane.showInputDialog("Enter guess " + currentGuesses));
			// if guess is out of range prompt user again
			if (guess < 0 || guess > 100) {
				JOptionPane.showMessageDialog(null, "OOPS!, your guess needs to be between 0 and 100");
			}

			System.out.println(currentGuesses);
			// set current index (currentguesses) of total guesses with value of guess
			totalGuesses[currentGuesses] = guess;
			System.out.println(totalGuesses[currentGuesses]);
			// increment currentguesses
			currentGuesses = currentGuesses + 1;
			// get remaining user lives by decreasing by currentguesses
			int remaining = userLives - currentGuesses;
			int choice;

			// if statements to check if the user enters a lower number or higher number and
			// tells user to go lower or higher
			// decreases lives with every guess and tells user how many lives are left
			if (guess < randomNumber && currentGuesses != userLives) {

				JOptionPane.showMessageDialog(null, "You need to go higher!");
				JOptionPane.showMessageDialog(null, "You have " + remaining + " lives remaining");
			} else if (guess > randomNumber && currentGuesses != userLives) {
				JOptionPane.showMessageDialog(null, "You need to go lower!");
				JOptionPane.showMessageDialog(null, "You have " + remaining + " lives remaining");
			} else if (guess == randomNumber) {
				// if user gets the guess right, terminate the loop and ask if user wants to try
				// again
				JOptionPane.showMessageDialog(null, "You guessed " + guess + " which is right! you've won!");
				JOptionPane.showMessageDialog(null, "You had " + remaining + " lives remaining");

				choice = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Select an option",
						JOptionPane.YES_NO_OPTION);
				System.out.println(choice);
				if (choice == 0) {
					gameMenu();
				} else if (choice == 1) {
					JOptionPane.showMessageDialog(null, "Thanks for playing");
					currentGuesses += userLives + 1;
				}

			}
			// if the user has run out of lives display loss dialog and choice if they want
			// to play again
			if (currentGuesses == userLives) {
				JOptionPane.showMessageDialog(null, "Sorry you have lost! You have no lives left!");
				String result = "";
				int gameGuesses[] = new int[totalGuesses.length];
				int i = 0;
				// this code will go through the total guess array and assign the absolute value
				// from the difference of each index of total guess and store the value in the
				// gameguesses and display in one dialog message
				// this will then display to the user how far they were from the right answer
				while (i < totalGuesses.length) {
					result += "Your guess: " + i + ", which was: " + totalGuesses[i] + " , was "
							+ Math.abs((gameGuesses[i] = (int) (totalGuesses[i] - randomNumber))) + " far from "
							+ randomNumber + " \n";
					i += 1;
				}
				JOptionPane.showMessageDialog(null, result);
				choice = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Select an option",
						JOptionPane.YES_NO_OPTION);
				System.out.println(choice);
				if (choice == JOptionPane.YES_OPTION) {
					gameMenu();
				} else if (choice == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Thanks for playing");

				}
			}

		}

	}

}
