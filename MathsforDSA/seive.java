public class seive {
    public static void main(String[] args) {
        int n=40;
        boolean primes[] = new boolean[n+1];
        Seive(n,primes);
    }
    //false in array means number is prime
    //because in boolean , it contain only false initially
    public static void Seive(int n,boolean[] primes){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(!primes[i]){
                for(int j=i*2;j<=n;j=j+i){
                    primes[j]=true;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(!primes[i]){
                System.out.println(i + " ");
            }
        }
    }
}
