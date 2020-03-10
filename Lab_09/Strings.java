// ******************************************************
// Numbers.java
//
// Apply selectionSort on an array of strings.
// ******************************************************

import java.util.Scanner;

public class Strings {
	
	// --------------------------------------------
	// Reads in an array of strings, sorts them,
	// then prints them in sorted order.
	// --------------------------------------------
	
	public static void main (String[] args) {
		
		String[] strList;
		int size;
		Scanner scan = new Scanner(System.in);
		System.out.print("\nBerapa string yang akan di-sort? ");
		size = scan.nextInt();
		strList = new String[size];
		System.out.println("\nKetik string-string yang akan di-sort ...");
		for (int i = 0; i < size; i++) {
			strList[i] = scan.next();
		}
		scan.close();
		Sorting<String> sorts = new Sorting<>();
		sorts.selectionSort(strList);
		System.out.println("\nHasil dalam sorted order...");
		for (int i = 0; i < size; i++) {
			System.out.print(strList[i] + " ");
		}
		System.out.println();
	}
}