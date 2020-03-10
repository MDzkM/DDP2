/**
A magic square that is constructed by a the "right and down" algorithm.
*/

public class MagicSquare {
	private int[][] square;
	private int size;

	/**
	Construct a MagicSquare object
	(precondition: s is odd).
	@param s the size of the square
	*/

	public MagicSquare(int s) {
		size = s;
		square = new int[size][size];
	
		//initialize the square
		for (int i = 0; i < size ; i++)
			for (int j = 0; j < size ; j++)
				square[i][j] = 0;
		
		int row = (size - 1), column = (size / 2);
		
		for (int i = 0; i < (size * size); i ++) {
			if (square[row][column] == 0) {
				square[row][column] = i;
				row = (row + 1) % size;
				column = (column + 1) % size;
			}
			
			else {
				row = (row - 2 + size) % size;
				column = (column - 1 + size) % size;
				square[row][column] = i;
				row = (row + 1) % size;
				column = (column + 1) % size;
				
			}
		}
	}
	
	/**
	 Find the sum of the diagonal.
	 @return sum: the sum of the diagonal
	 */
	
	public int diagonalSum() {
		int sum = 0;
		
		for (int i = 0; i < size; i++) {
			sum += square[i][i];
		}
		
		return sum;
	}
	
	/**
	 Add the numbers in a column of the square.
	 @param i the column index
	 @return the sum of the column
	*/
	
	public int columnSum(int i) {
		int sum = 0;
		
		for (int j = 0; j < size; j++) {
			sum += square[j][i];
		}
		
		return sum;
	}
	
	/**
	 Add the numbers in a row of the square.
	 @param i the row index
	 @return the sum of the row
	*/
	
	public int rowSum(int i) {
		int sum = 0;
		
		for (int j = 0; j < size; j++) {
			sum += square[i][j];
		}
		
		return sum;
	}
	
	/**
	 Gets a string representation of the contents of this square.
	 @return a string represenation of the square
	*/
	
	public String toString() {
		String r = "";
		for (int i = 0; i < size ; i++) {
			for (int j = 0; j < size ; j++)
				r = r + String.format("%5d", square[i][j]);
			r = r + "\n";
		}
		return r;
	}
}