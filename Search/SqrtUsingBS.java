package Search;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class SqrtUsingBS {
    public static void main(String[] args) {
        int n = 28;
        System.out.println("Square Root of " +n +" : " +BinarySearch(n));
    }
    public static int BinarySearch(int n){
        int low = 1 ;
        int ans = 1;
        int high = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mid * mid <= n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }
        }
        return ans;
    }
    
}
