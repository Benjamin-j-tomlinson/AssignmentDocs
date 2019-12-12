import java.util.Scanner; // import the java scanner class from the java.util package
import javax.swing.JOptionPane;

//In order to fulfill the requirements of the bonus criteria for the code to be executed after use input had to be violated 
//in order for the story to be progressive as the user would have no idea what the story is about before making a decision

public class StoryMaker { // Class Assignment 1 code block containing the main method

	public static void main(String[] args) { // Main method code block containing an array of string objects

		// can use new scanner object passed into a variable but chosen Joption pane
		// instead

		// Prompting the user for input using the system input
		// using JOption pane to receive input and store in the
		// associated variables

		// parsed string to an integer to use the following method to get an integer
		// input from the user.
		// variable days, exception is thrown if invalid value is entered 
		int days = Integer.parseInt(JOptionPane.showInputDialog("Enter amount of days"));

		String storyPart1 = JOptionPane.showInputDialog("Enter the first part of the story");
		String storyPartDescription1 = JOptionPane.showInputDialog("Enter a description of the story object 1");
		;
		String storySounds1 = JOptionPane.showInputDialog("Enter a sound for the story object 1");

		String storyPart2 = JOptionPane.showInputDialog("Enter the second part of the story");
		String storyPartDescription2 = JOptionPane.showInputDialog("Enter a description of the story object 2");
		;
		String storySounds2 = JOptionPane.showInputDialog("Enter a sound for the story object 2");

		String storyPart3 = JOptionPane.showInputDialog("Enter the third part of the story");
		String storyPartDescription3 = JOptionPane.showInputDialog("Enter a description of the story object 3");
		;
		String storySounds3 = JOptionPane.showInputDialog("Enter a sound for the story object 3");

		String storyPart4 = JOptionPane.showInputDialog("Enter the fourth part of the story");
		String storyPartDescription4 = JOptionPane.showInputDialog("Enter a description of the story object 4");
		;
		String storySounds4 = JOptionPane.showInputDialog("Enter a sound for the story object 4");

		String storyPart5 = JOptionPane.showInputDialog("Enter the fifth part of the story");
		String storyPartDescription5 = JOptionPane.showInputDialog("Enter a description of the story object 5");
		;
		String storySounds5 = JOptionPane.showInputDialog("Enter a sound for the story object 5");

		// lyrics to the first part of the story stored in the bearHuntLyrics string
		// variable

		// Story created by Machael Rosen
		// [6]M. Rosen, "Going on a bear hunt", Case.cy.edu.tw, 2019.
		// [Online]. Available:
		// http://case.cy.edu.tw/mediafile/4220012/news/350/2010-9/72010-9-13-15-47-52-nf1.pdf.
		// [Accessed: 05- Sep- 2019].

		String bearHuntLyics = "We're going on a bear hunt in" + " " + days + " " + "days" + ".\r\n"
				+ "We're going to catch a big one.\r\n" + "What a beautiful day!\r\n" + "We're not scared.\r\n"
				+ "Uh-uh!\r\n" + storyPart1 + "\r\n" + storyPartDescription1 + " " + storyPart1 + "\r\n"
				+ "We can't go over it.\r\n" + "We can't go under it.\r\n" + "Oh no!\r\n"
				+ "We've got to go through it!\r\n" + storySounds1 + " " + storySounds1 + " " + storySounds1 + "\r\n"
				+ "We're going on a bear hunt.\r\n" + "We're going catch a big one.\r\n" + "What a beautiful day!\r\n"
				+ "We're not scared.\r\n" + "Uh-uh!\r\n" + storyPart2 + "\r\n" + storyPartDescription2 + " "
				+ storyPart2 + "\r\n" + "We can't go over it.\r\n" + "We can't go under it.\r\n" + "Oh no!\r\n"
				+ "We've got to go through it!\r\n" + storySounds2 + " " + storySounds2 + " " + storySounds2 + "\r\n"
				+ "We're going on a bear hunt.\r\n" + "We're going catch a big one.\r\n" + "What a beautiful day!\r\n"
				+ "We're not scared. \r\n" + "Uh-uh!\r\n" + storyPart3 + "\r\n" + storyPartDescription3 + " "
				+ storyPart3 + "\r\n" + "We can't go over it,\r\n" + "We can't go under it.\r\n" + "Oh no!\r\n"
				+ "We've got to go through it!\r\n" + storySounds3 + " " + storySounds3 + " " + storySounds3 + "\r\n"
				+ "We're going on a bear hunt.\r\n" + "We're going to catch a big one.\r\n"
				+ "What a beautiful day!\r\n" + "We're not scared.\r\n" + "Uh-uh!\r\n" + storyPart4 + "\r\n"
				+ storyPartDescription4 + " " + storyPart4 + "\r\n" + "We can't go over it.\r\n"
				+ "We can't go under it.\r\n" + "Oh no!\r\n" + "We've got to go through it!\r\n" + storySounds4 + " "
				+ storySounds4 + " " + storySounds4 + "\r\n" + "We're going on a bear hunt.\r\n"
				+ "We're going to catch a big one.\r\n" + "What a beautiful day!\r\n" + "We're not scared.\r\n"
				+ "Uh-uh!\r\n" + storyPart5 + "\r\n" + storyPartDescription5 + " " + storyPart5 + "\r\n"
				+ "We can't go over it.\r\n" + "We can't go under it.\r\n" + "Oh no!\r\n"
				+ "We've got to go through it!\r\n" + storySounds5 + " " + storySounds5 + " " + storySounds5 + "\r\n"
				+ "We're going on a bear hunt.\r\n" + "We're go to catch a big one.\r\n" + "What a beautiful day!\r\n"
				+ "We're not scared.\r\n" + "Uh-uh!\r\n" + "A cave!\r\n" + "A narrow gloomy cave.\r\n"
				+ "We can't go over it.\r\n" + "We can't go under it.\r\n" + "We've got to go through it!\r\n";
		System.out.println(bearHuntLyics);
		// ask user if they want to enter the cave to progress through the story
		// store result yes or other value in string enterOrNot
		
		String enterOrNot = JOptionPane.showInputDialog("Enter the cave?");

		// Declaring enterCave variable but not initialised
		// Other data types such as an integer can be used with operators to assess the
		// value in an if statement
		boolean enterCave;

		// if statement, if the user entered yes or Yes the condition is true and the
		// boolean is set to true else it's
		// false and the boolean is set to false

		if (enterOrNot.equals("yes") | enterOrNot.equals("Yes")) {
			enterCave = true;
		} else {
			enterCave = false;
		}

		// it's not entirely necessary to use the boolean as the string can be used as a
		// condition for the if statement or other data types like int
		// if user entered yes, enterCave boolean is true and the user wants to enter
		// the cave the first block is executed and the user enters the cave
		// if the user entered no, enterCave is false and the user goes home
		// both blocks attach statements to the bearHuntLyrics variable to finish the
		// story
		if (enterCave) {

			bearHuntLyics = "Tiptoe! Tiptoe! Tiptoe!\r\n" + "WHAT’S THAT!\r\n" + "One shiny wet nose!\r\n"
					+ "Two big furry ears!\r\n" + "Two big goggly eyes!\r\n" + "IT’S A BEAR!\r\n" + "Quick!\r\n"
					+ "Back through the cave!\r\n" + "Tiptoe! Tiptoe! Tiptoe!\r\n" + "Back through the" + " "
					+ storyPart1 + "\r\n" + storySounds1 + " " + storySounds1 + " " + storySounds1 + "\r\n"
					+ "Back through the" + " " + storyPart2 + "\r\n" + storySounds2 + " " + storySounds2 + " "
					+ storySounds2 + "\r\n" + "Back through the" + " " + storyPart3 + "\r\n" + storySounds3 + " "
					+ storySounds3 + " " + storySounds3 + "\r\n" + "Back through the" + " " + storyPart4 + "\r\n"
					+ storySounds4 + " " + storySounds4 + " " + storySounds4 + "\r\n" + "Back through the" + " "
					+ storyPart5 + "\r\n" + storySounds5 + " " + storySounds5 + " " + storySounds5 + "\r\n"
					+ "Get to our front door.\r\n" + "Open the door.\r\n" + "Up the stairs\r\n" + "Oh no! \r\n"
					+ "We forgot to shut the door.\r\n" + "Back down stairs.\r\n" + "Back upstairs.\r\n"
					+ "Into the bedroom\r\n" + "In to the bed\r\n" + "Under the covers\r\n"
					+ "I’m not going on a bear hunt again.";
		}

		// if the condition is false the alternative ending is displayed
		else {
			bearHuntLyics = "We don't want to go through, lets go home.";
		}

		// Display the value in bearHuntLyrics
		System.out.println(bearHuntLyics);
		// JOptionPane.showMessageDialog(null, bearHuntLyics); can be used but dialog
		// box too small and needs modifying

		// ERRORS AND BUGS
		// Bugs in the code include, allowing user to not enter a value and the program
		// still runs
		// the user is not restricted to what value they can enter, therefore the story
		// can run and not make sense
		// the code is repetitive and needs refactoring, use of loops and data
		// structures to decrease the amount of code

	}

}
