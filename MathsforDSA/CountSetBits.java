public class CountSetBits {
    public static void main(String[] args) {
        int n =10;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setBits(n));
    }
    private static int setBits(int n){
        int count =0;

        while(n > 0){
            n-= (n & -n); //Subtract the rightmost set bit in 'n' from 'n'. This is equivalent to subtracting all the lower order bits of 'n', i
            // n = n&(n-1);   // bitwise AND operation to remove the rightmost set bit in each step
            count++;
        }

        return count;
    }
}
