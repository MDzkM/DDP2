public class TestMagicSquare {
	public static void main(String[] args) {
		int n = 0; //size of magic square
		//Process input from command-line
		if (args.length == 1) {
			try {
				n = Integer.parseInt(args[0]);
				if (n % 2 == 0) {
					System.out.println("Usage: java -jar <jarFile> <odd size of square>");
					System.exit(1);
				}
			}
			
			catch (Exception e) {
				System.out.println("Usage: java -jar <jarFile> <odd size of square>");
				System.exit(1);
			}
		}
		
		else {
			System.out.println("Usage: java -jar <jarFile> <odd size of square>");
			System.exit(1);
		}
		
		//Create an object of MagicSquare
		MagicSquare ms = new MagicSquare(n);
		// Print the results
		System.out.println("Magic Square of size " + n + "x" + n + ":\n\n" + ms +
						   "\nMain diagonal sum: " + ms.diagonalSum() +
						   "\nColumn sum: " + ms.columnSum(0) +
						   "\nRow sum: " + ms.rowSum(n-1) + "\n");
	}
}