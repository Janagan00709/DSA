public class even {
    public static void main(String[] args) {
      int n = 67;
      System.out.println(isOdd(n));
    }
  
    // method to check if a number is odd or not
    static boolean isOdd(int n) {
      return (n & 1) == 1;
    }
  }