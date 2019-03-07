package ddp2.tp01;

import javax.swing.JOptionPane;
import java.lang.Math;

public class CreditCardValidator {

	public static void main(String[] args) {
		String cardNumber;
		cardNumber = JOptionPane.showInputDialog(null,
				"Enter a credit card / debit card number as a long integer, QUIT to end:\n",
				"Validation of Credit Card / Debit Card Numbers", JOptionPane.PLAIN_MESSAGE);
		
		while (cardNumber != null && !cardNumber.equalsIgnoreCase("quit")) {
			long longNumber =  Long.parseLong(cardNumber);
			if (isValid(longNumber)) {
				JOptionPane.showMessageDialog(null, "Validation of Credit Card / Debit Card Numbers", "The number" + longNumber + " is valid", JOptionPane.PLAIN_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Validation of Credit Card / Debit Card Numbers", "The number" + longNumber + " is invalid", JOptionPane.PLAIN_MESSAGE);
			}

			cardNumber = JOptionPane.showInputDialog(null,
					"Enter a credit card / debit card number as a long integer, QUIT to end:\n",
					"Validation of Credit Card / Debit Card Numbers", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		final int VISA_CARDS = 4, MASTER_CARDS = 5, AMERICAN_EXPRESS_CARDS = 37, DISCOVER_CARDS = 6;
		
		if (prefixMatched(number, VISA_CARDS) || prefixMatched(number, MASTER_CARDS) || prefixMatched(number, AMERICAN_EXPRESS_CARDS) || prefixMatched(number, DISCOVER_CARDS)) {
			if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	 /** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		number /= 10;
		while (number > 0) {
			sum += getDigit((int)(number % 10));
			number /= 100;
		}
		
		return sum;
	}
	
	 /** Return this number if it is a single digit, otherwise,
	 * return the sum of the two digits */
	public static int getDigit(int number) {
		if (number * 2 < 10) {
			return number * 2;
		}
		
		else {
			return ((number * 2) / 10) + ((number * 2) % 10);
		}
	}
	
	 /** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		while (number > 0) {
			sum += (number % 10);
			number /= 100;
		}
	
		return sum;
	}
	
	 /** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		int numberSize = getSize(number);
		if (number / Math.pow(10, (numberSize - 1)) == d) {
			return true;
		}
		if (number / Math.pow(10, (numberSize - 2)) == d) {
			return true;
		}
		return false;
	}
	
	 /** Return the number of digits in d */
	public static int getSize(long number) {
		return ((int) Math.ceil(Math.log10(number + 1)));
	}	
}
