//*********************************************
//	MyFactorial.java
//
//	Print the factorial of a positive int <= 10
//	using the switch statement
//*********************************************

import java.util.Scanner;

public class MyFactorial {

	public static void main(String[] args) {
		Scanner inputkb = new Scanner(System.in);
		System.out.println("Enter a positive integer <= 10: ");
		int n = inputkb.nextInt();
		inputkb.close();
		var result = 1;
		switch(n) {
			case 10: result *= 10;
			case 9: result *= 9;
			case 8: result *= 8;
			case 7: result *= 7;
			case 6: result *= 6;
			case 5: result *= 5;
			case 4: result *= 4;
			case 3: result *= 3;
			case 2: result *= 2; break;
			default:
		}
		System.out.println((n>0 && n <= 10) ? (n + "! = " + result) : "out of range");
		
	}

}
