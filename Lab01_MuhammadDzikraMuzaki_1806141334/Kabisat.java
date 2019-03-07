// Import necessary libraries for user input.
import java.util.Scanner;

public class Kabisat {
  public static void main(String[] args) {

    // Initiates Scanner.
    Scanner input = new Scanner(System.in);

    // Asks for user input.
    int var = input.nextInt();

    // If else statements to determine birth leap year.
    if (var % 400 == 0) {
      System.out.println("Anda lahir di tahun kabisat.");
    }
    else if (var % 100 == 0) {
      System.out.println("Anda tidak lahir di tahun kabisat.");
    }
    else if (var % 4 == 0) {
      System.out.println("Anda lahir di tahun kabisat.");
    }
    else {
      System.out.println("Anda tidak lahir di tahun kabisat.");
    }

  }
}
