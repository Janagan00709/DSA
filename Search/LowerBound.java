package Search;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class LowerBound {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,5,8,8,10};
        int target = 9;
        System.out.println(BinarySearch(arr,target));
    }
    public static int BinarySearch(int[] arr,int target){
        int low = 0 ;
        int high = arr.length - 1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
