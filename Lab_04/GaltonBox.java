/**
GaltonBox.java
Ide program:
Buat sebuah array bernama slots. Each element in slots stores the number
of balls in a slot. Each ball falls randomly into a slot via a path.
The number of Rs in a path is the position of the slot where the ball falls.
For example, for the path LRLRLRR, the ball falls into slots[4] (because
there are 4 Rs), and for the path RRLLLLL, the ball falls into slots[2]
(because there are 2 Rs).
*/

import java.util.Scanner;

public class GaltonBox {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Masukkan jumlah bola: ");
		int numberOfBalls = input.nextInt();

		System.out.print("Masukkan jumlah slot: ");
		int numberOfSlots = input.nextInt();

		int[] slots = new int[numberOfSlots];

		System.out.println();
		
		for (int i = 0; i < numberOfBalls; i++) {
			slots[onePath(numberOfSlots)]++;
		}
		printHistogram(slots);
		input.close();
	}

 /**
 Return the slot position of the ball for a random path and
 also print the path
 */
	
	public static int onePath(int numberOfSlots) {
		int position = 0;

		for (int i = 0; i < numberOfSlots - 1; i++)
			if (Math.random() < 0.5) {
				System.out.print("L");
			}
			else {
				System.out.print("R");
				position++;
			}

		System.out.println();

		return position;
	}

	
 /**
 Print the histogram for the slots,
 from top to bottom row by row
 */
	
	public static void printHistogram(int[] slots) {
		int maxSlotHeight = max(slots);

		System.out.println();
		for (int h = maxSlotHeight; h > 0; h--) {
			for (int i = 0; i < slots.length; i++)
				if (slots[i] < h)
					System.out.print(" "); // Print nothing
				else
					System.out.print("O"); // Print a ball

				System.out.println();
		}
		for (int i = 0; i < slots.length; i++)
			System.out.print("-");
		System.out.println();
	}

 /**
 Get the max element in slots
 */
	
	public static int max(int[] slots) {
		int max = slots[0];
	    for (int h = 0; h < slots.length; h++) {
	        if (slots[h] > max) {
	            max = slots[h];
	        }
	    }
	    return max;
	}
}