package Search;
//Facebook question
public class FirstAndLastPosition {
    public static void main(String[] args) {
        
    }
    public static int[] searchRange(int[] nums, int target) {
        
        int[] ans={-1,-1};
        // Check for fiirst occurance of target first

        int start = search(nums,target,true);
        int end = search(nums,target,false);
        ans[0]=start;
        ans[1]=end;
        return ans;
    }
    //this function just returns the index value of target
    static int search(int[] nums,int target,boolean findStartIndex){
        int ans=-1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // int mid = (start+end)/2 This may exceed the int range , so we can use below
            // equation
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
               //potential ans found
               ans =mid;
               if(findStartIndex==true){
                    end = mid -1;
               }else{
                    start=mid + 1;
               }
            } 
        }
        return ans;
    }
}
