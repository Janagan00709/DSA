package Search;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class MinimumInRotatedArrayUsingBS {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3,4,5};
        System.out.println("Minimum: " +BinarySearch(arr));
    }
    public static int BinarySearch(int[] arr){
        int low = 0 ;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;
            // Left sorted
            if(arr[low] <= arr[mid]){
                ans = Math.min(arr[low],ans);
                low = mid + 1; // omitting the left
            }
            // Right sorted
            else{
                ans = Math.min(arr[mid],ans);
                high = mid - 1; // omitting the right
            }
        }
        return ans;
    }
    
}
