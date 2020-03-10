public class SimpleLog {
  public static void main(String[] args) {

    // Declare variables.
    int number = 100;
    int base = 2;
    int log = 0;
    int numberBefore = number;

    // While loop to find the log.
    while (number >= base) {
      number /= base;
      log++;
    }

    // Prints result.
    System.out.println("Logaritma basis " + base + " dari " + numberBefore +
    " adalah " + log);
  }
}
