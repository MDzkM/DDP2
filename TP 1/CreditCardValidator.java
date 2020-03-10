import javax.swing.JOptionPane;
import java.lang.Math;

public class CreditCardValidator {

	public static void main(String[] args) {
		String cardNumber;
		cardNumber = JOptionPane.showInputDialog(null,
												 "Enter a credit card / debit card number as a long integer, QUIT to end:\n",
												 "Validation of Credit Card / Debit Card Numbers",
												 JOptionPane.PLAIN_MESSAGE);
		
		while (cardNumber != null && !cardNumber.equalsIgnoreCase("quit")) {
			
			// Try - Catch block to handle errors regarding invalid inputs
			try {
				
				// Check if first digit is 0 before converting to long
				if (cardNumber.charAt(0) != '0') {
					long longNumber =  Long.parseLong(cardNumber);
					
					// Validates credit card / debit card number
					if (isValid(longNumber)) {
						JOptionPane.showMessageDialog(null,
													  "The number " + longNumber + " is valid",
													  "Validation of Credit Card / Debit Card Numbers",
													  JOptionPane.PLAIN_MESSAGE);
					}
					
					else {
						JOptionPane.showMessageDialog(null,
													  "The number " + longNumber + " is invalid",
													  "Validation of Credit Card / Debit Card Numbers",
													  JOptionPane.PLAIN_MESSAGE);
					}
				}
				
				else {
					JOptionPane.showMessageDialog(null,
												  "The number " + cardNumber + " is invalid",
												  "Validation of Credit Card / Debit Card Numbers",
												  JOptionPane.PLAIN_MESSAGE);
				}

				cardNumber = JOptionPane.showInputDialog(null,
														 "Enter a credit card / debit card number as a long integer, QUIT to end:\n",
														 "Validation of Credit Card / Debit Card Numbers",
														 JOptionPane.PLAIN_MESSAGE);
			}
			
			// Exception handling
			catch (Exception e) {
				JOptionPane.showMessageDialog(null,
											  "Invalid input",
											  "Validation of Credit Card / Debit Card Numbers",
											  JOptionPane.PLAIN_MESSAGE);
				cardNumber = JOptionPane.showInputDialog(null,
														 "Enter a credit card / debit card number as a long integer, QUIT to end:\n",
														 "Validation of Credit Card / Debit Card Numbers",
														 JOptionPane.PLAIN_MESSAGE);
			}
			
		}
	}
	
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		// Declaring constants of valid card prefixes
		final int VISA_CARDS = 4, 
				  MASTER_CARDS = 5, 
				  AMERICAN_EXPRESS_CARDS = 37, 
				  DISCOVER_CARDS = 6;
		
		// Check if number of digits is inside the range
		if ((getSize(number) >= 13) && (getSize(number) <= 16)){
			
			// Checking number prefix 
			if (prefixMatched(number, VISA_CARDS) || 
				prefixMatched(number, MASTER_CARDS) || 
				prefixMatched(number, AMERICAN_EXPRESS_CARDS) || 
				prefixMatched(number, DISCOVER_CARDS)) {
				
				// Checksum for card number
				if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
					return true;
				}
				
				return false;
			}
			
			return false;
		}
		
		return false;
	}
	
	 /** Return sum of even-place digits in number */
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		
		// Discarding the first odd digit from the right
		number /= 10;
		
		// While loop to get each even digit from the right
		while (number > 0) {
			sum += getDigit((int)(number % 10));
			number /= 100;
		}
		
		return sum;
	}
	
	 /** Return this number if it is a single digit, otherwise,
	 * return the sum of the two digits */
	public static int getDigit(int number) {
		
		// Return result if not bigger than 10
		if (number * 2 < 10) {
			return number * 2;
		}
		
		// Return result and discarding the first digit if bigger than 10
		else {
			return ((number * 2) / 10) + ((number * 2) % 10);
		}
	}
	
	 /** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		
		// While loop to get each odd digit from the right
		while (number > 0) {
			sum += (number % 10);
			number /= 100;
		}
	
		return sum;
	}
	
	 /** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		
		// Check if the first digit of number is equal to the declared prefix (d)
		if (getPrefix(number, d) == d) {
			return true;
		}
		
		return false;
	}
	
	 /** Return the number of digits in d */
	public static int getSize(long d) {
		return (int) Math.ceil(Math.log10(d + 1));
	}
	
	/** Return the first k number of digits from number. If the
	 * number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k) {
		
		// Get the length of number and prefix
		long numSize = getSize(number), kSize = getSize(k);
		
		// Return number if length is smaller than prefix
		if (numSize < kSize) {
			return number;
		}
		
		// Reduce number length from the right
		while (numSize > kSize) {
			number /= 10;
			numSize--;
		}
		
		return number;
	}
}
