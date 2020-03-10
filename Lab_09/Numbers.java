// ******************************************************
// Numbers.java
//
// Apply selectionSort on an array of integers.
// ******************************************************

import java.util.Scanner;

public class Numbers {
	
	// --------------------------------------------
	// Reads in an array of integers, sorts them,
	// then prints them in sorted order.
	// --------------------------------------------
	
	public static void main (String[] args) {
		
		Integer[] intList;
		int size;
		Scanner scan = new Scanner(System.in);
		System.out.print("\nBerapa integer yang akan di-sort? ");
		size = scan.nextInt();
		intList = new Integer[size];
		System.out.println("\nKetik integer-integer yang akan di-sort ...");
		for (int i = 0; i < size; i++) {
			intList[i] = scan.nextInt();
		}
		scan.close();
		Sorting<Integer> sorts = new Sorting<>();
		sorts.selectionSort(intList);
		System.out.println("\nHasil dalam sorted order...");
		for (int i = 0; i < size; i++) {
			System.out.print(intList[i] + " ");
		}
		System.out.println();
	}
}