
/* PSEUDO CODE
 * In a do while loop, Ask user to enter a string
 * check to make sure that the character isn't one of the special characters
 * put each character in the string into a char array
 * add one to the string counter
 * function: isPalindrome
 * 	checks if the entered string is a palindrome by reversing the array and comparing the inputted string to the reversed string
 * 	if they are the same then it is a palindrome, if not then it isn't
 * 	out put the proper messages depending upon the status add one to palindrome counter if it is
 * 
 * In main, ask the user if the want to enter another string
 * if no end loop and print out number of things entered and number of palindromes
 * if yes repeat
 */
import java.util.Scanner;

public class A9akroonPalindrome {
	public static final char[] SPECIAL_CHARACTERS = new char[] { ' ', ',', ';', '&', '.', '!', '\'', ':', '?', '-',
	'"' };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input, cleanInput ="", rawAnswer;
		int stringCount = 0, palCount = 0;
		int n = 0;
		boolean answer = true;

		do {
			input = "";
			cleanInput = "";
			rawAnswer = "";
			n = 0;
			System.out.println("Please enter your string: ");
			input = s.nextLine();
			stringCount++;
			
			while (n != input.length()) {
				input = input.toLowerCase();
				char thisChar = input.charAt(n);
				boolean good = true;
				for (int c = 0; c < SPECIAL_CHARACTERS.length; c++) {
					if (thisChar == SPECIAL_CHARACTERS[c]) {
						n++;
						good = false;
						break;
					} else {
						continue;
					}
				}
				if(good == true){
				cleanInput += thisChar;
				n++;
				}
			}

			char[] myPal = new char[cleanInput.length()];
			for (int i = 0; i < cleanInput.length(); i++) {
				char thisChar = cleanInput.charAt(i);
				myPal[i] = thisChar;
			}
			boolean isDrome = isPalindrome(myPal, cleanInput);
			if (isDrome == true) {
				System.out.println("This is a palindrome.");
				palCount++;
			} else {
				System.out.println("This is not a palindrome.");
			}
			boolean goodAnswer = false;
			while(goodAnswer == false){
			System.out.println("Would you like to enter another palindrome? yes/no");
			rawAnswer = s.nextLine();
			if (rawAnswer.toLowerCase().equals("yes")) {
				answer = true;
				goodAnswer = true;
			} 
			else if (rawAnswer.toLowerCase().equals("no")) {
				answer = false;
				goodAnswer = true;
			}
			else{
				System.out.println("Improper response.");
				goodAnswer = false;
			}
			}

		} while (answer == true);
		
		s.close();
		System.out.println("You entered " + stringCount + " strings and " + palCount + " palindromes.");
			
	}

	public static boolean isPalindrome(char[] thisArry, String inputStr) {
		boolean output = true;
		String reverse = "";
		char oneChar;
		for (int i = thisArry.length - 1; i >= 0; i--) {
			oneChar = thisArry[i];
			reverse += oneChar;
		}
		if (inputStr.equals(reverse)) {
			output = true;
		} else{
			output = false;
		}
		return output;
	}

}
