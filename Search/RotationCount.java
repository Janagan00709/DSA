package Search;

public class RotationCount {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(countRotations(nums));
    }
    public static int countRotations(int [] nums){
        int pivot = findPivot(nums);
        // if(pivot==-1){
        //     //array is not rotated
        //     return 0;
        // }
        return pivot + 1;
    }
    static int findPivot(int[] nums){
        int start = 0;
        int end= nums.length-1;
        while(start<=end){
            int mid = start +(end -start)/2;
            if(mid < end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            //if elements at middle, start,end are equal then just skip the duplicates
            if(nums[mid]==nums[start] && nums[mid]==nums[end]){
                // Skip duplicates
                //Note: what if these elements at start and end were the pivot
                //check if start is pivot
                if(nums[start] > nums[start+1]){
                    return start;
                }
                start++;
                if(nums[end] > nums[end-1]){
                    return end;
                }
                end--;
            }
            //left side is sorted , so pivot should be in right
            else if(nums[start] < nums[mid] || (nums[start]==nums[mid] && nums[mid]> nums[end])){
                start = mid + 1;
            }else{
                 end = mid - 1;
            }
        }
        return -1;
    }
}
