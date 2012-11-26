public class Fibonacci {

  public static void main(String[] args) {
    // Berechne die ersten 71 Fibonacci-Zahlen
    for (int i = 0; i <= 70; i++) {
      System.out.print(i + ": ");
      System.out.println(fib(i));
    }
  }

}
