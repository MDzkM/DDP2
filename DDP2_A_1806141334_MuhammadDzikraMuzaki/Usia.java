public class Usia{
  public static void main (String[] args) {
    int usia = 19;
    if (usia <= 10) {
      System.out.println("Orang berusia " + usia + " masih anak-anak");
    }
    else if (usia <= 20) {
      System.out.println("Orang berusia " + usia + " sudah remaja");
    }
    else if (usia <= 50) {
      System.out.println("Orang berusia " + usia + " sudah dewasa");
    }
    else {
      System.out.println("Orang berusia " + usia + " sudah tua");
    }
  }
}
