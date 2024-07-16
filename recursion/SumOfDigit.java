public class SumOfDigit {
    public static void main(String[] args) {
        int ans = 1342;
        System.out.println("The sum of digit is " + sumOfDigit(ans));
    }

    static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigit(n / 10);
    }
}
