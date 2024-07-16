public class UniqueElement {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4};
        System.out.println("For two times repeating: ");
        System.out.println(ans(arr));
        System.out.println("For 3 times repeating:");
        int[] arr1={2,2,4,2,7,7,8,7,8,8};
        System.out.println(unique(arr1));
    }
    private static int ans(int[] arr){
        int unique=0;
        for(int n:arr){
            unique^=n;
        }
        return unique;
    }
    private static int unique(int[] arr1){
        int sum=0;
        for(int num:arr1){
            sum+=num;
        }
        return sum%3;
    }

}
