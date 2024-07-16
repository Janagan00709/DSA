public class ProductOfDigit{
    public static void main(String[] args) {
        int ans = 1342;
        System.out.println("The Product of digit is " + productOfDigit(ans));
    }

    static int productOfDigit(int n) {
        if (n <=1) {  // if(n%10==n) return n;
            return 1;
        }
        return n % 10 * productOfDigit(n / 10);
    }
}
