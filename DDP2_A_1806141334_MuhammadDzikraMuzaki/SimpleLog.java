public class SimpleLog {
  public static void main(String[] args) {
    int number = 100;
    int base = 2;
    int log = 0;
    int numberBefore = number;
    while (number >= base) {
      number /= base;
      log++;
    }
    System.out.println("Logaritma basis " + base + " dari " + numberBefore +
    " adalah " + log);
  }
}
