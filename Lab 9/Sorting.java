//********************************************************************
// Sorting.java
//
// Demonstrates the selection sort algorithm with generic type T.
//********************************************************************

public class Sorting<T> {
	
	//-----------------------------------------------------------------
	// Sorts the specified array of objects of type T using the
	// selection sort algorithm.
	//-----------------------------------------------------------------
	
	public void selectionSort(Comparable<T>[] list) {
		
		int min;
		Comparable<T> temp;
		for (int index = 0; index < list.length-1; index++) {
			
			// Find the index of the smallest value
			min = index;
			for (int scan = index; scan < list.length; scan++) {
				if (list[scan].compareTo((T)list[min]) < 0) {
					min = scan;
				}
			}
			// Swap the values
			temp = list[index];
			list[index] = list[min];
			list[min] = temp;
		}
	}
}