public class ReverseNumber {
    public static void main(String[] args) {
        int n =1842;
        System.out.println("The reverse of "+n+" is "+reverse(n));
    }
    static int reverse(int n){
        //sometimes you might need some additional variables in the arguments
        // In that case ,create another function
        int digits = (int)(Math.log10(n))+1;
        return helper(n,digits);
    }
    private static int helper(int n, int digits) {
        if(n%10==n){  // one digit number
            return n;
        }
        int rem = n%10;
        return rem * (int)(Math.pow(10,digits-1)) + helper(n/10,digits-1);
    }
    /* Normal methods and above is using recursion
     * static int sum = 0;
    static void rev(int n){
        if(n==0){
            System.out.println(sum);
            return;
        }
        int remainder = n%10;
        sum = sum*10+remainder;
        rev(n/10);
    }
    */
}
