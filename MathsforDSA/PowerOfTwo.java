public class PowerOfTwo {
   public static void main(String[] args) {
    int n=256;
    if(n==1){
        System.out.println("false");
    }
    boolean ans = (n&(n-1))==0;
    System.out.println(ans);
   }
    
}
