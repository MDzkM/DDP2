// **********************************************************
// CountChars.java
//
// This program reads in strings (phrases) and counts the
// number of blank characters, vowels, consonants,and other
// characters in the phrase.
// **********************************************************

import javax.swing.JOptionPane;

public class CountChars {
	public static void main(String[] args) {
		String phrase; // a string of characters
		int countSpace, countA, countE, countI, countO, countU, countConsonants, countOther, length;// other variables
		// Read in a string and find its length

		phrase = JOptionPane.showInputDialog(null,
				"Enter a sentence or phrase, quit to end:\n",
				"Character Counter", JOptionPane.PLAIN_MESSAGE);
		
		while (!phrase.equals("quit")) {
			length = phrase.length();
			// Initialize counts
			countSpace = 0;
			countA = 0;
			countE = 0;
			countI = 0;
			countO = 0;
			countU = 0;
			countConsonants = 0;
			countOther = 0;
			char ch;
			// a for loop to go through the string character by character
			// and count them by category
			for (int i = 0; i < length; i++) {
				ch = phrase.charAt(i);
				switch (ch) {
				 case 'a':
				 case 'A': countA++; break;
				 case 'e':
				 case 'E': countE++; break;
				 case 'i':
				 case 'I': countI++; break;
				 case 'o':
				 case 'O': countO++; break;
				 case 'u':
				 case 'U': countU++; break;
				 case ' ': countSpace++; break;
				 default: if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) countConsonants++; else countOther++;
				}

			}
			
			// Print the results

			JOptionPane.showMessageDialog(null,
					"Space: " + countSpace + "\nA: " + countA + "\nE: " +
							countE + "\nI: " + countI + "\nO: " + countO +
							"\nU: " + countU + "\nConsonants: " + countConsonants +
							"\nOthers: " + countOther + "\nThe input was: \n" +
							phrase, "Totals", JOptionPane.PLAIN_MESSAGE);

			//Get phrase for next time
			phrase = JOptionPane.showInputDialog(null,
					"Enter a sentence or phrase, quit to end:\n",
					"Character Counter", JOptionPane.PLAIN_MESSAGE);
		}
	}
}