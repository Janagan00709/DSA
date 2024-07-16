public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(1020400));
    }
    static int countZeros(int n) {
        return helper(n,0);
    }
    static int helper(int n,int c){
        if(n==0){
            return c;
        }
        int rem = n%10;
        if(rem==0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);

    }
    static int permutationscount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i, p.length());
            count=count+permutationscount(f+ch+s, up.substring(1));
        }
        return count;
    }
}
