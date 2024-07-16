public class Prime {
    public static void main(String[] args) {
        System.out.println(isprime(4));
    }
    static boolean isprime(int n){
        if(n<=1){
            return false;
        }
        int c=2;
        while(c*c<=n){ // i.e c <= math.sqrt(n)
            if(n%c==0){ 
                return false;
            }
            c++;
        }
        return true;
    }
}
