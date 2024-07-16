package Search;
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(findPivot(nums));
    }
    public static int search(int[] nums, int target) {
        int pivot =findPivot(nums);
        // If you did not find a pivot , it means the array is not rotated
        if (pivot == -1){
            //Just do normal binary search
            return BinarySearch(nums,target,0,nums.length - 1);
        }
        //if pivot is found, you have found 2 asc sorted array
        if(nums[pivot]==target){
            return pivot; 
        }
        if(target >= nums[0]){
            return BinarySearch(nums, target, 0, pivot-1);
        }
        return BinarySearch(nums, target,pivot+1,nums.length-1);

    }
    //Pivot - > greatest number in the array which sub arrays are in ascending order {3,4,5,1,2} 
    // In this case , the pivot is 5 
    // This is not suitable for duplicate elements
    static int findPivot(int[] nums){
        int start=0; 
        int end= nums.length-1;
        while(start<=end){
            int mid = start +(end -start)/2;
            if(mid < end && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            if(nums[mid]<=nums[start]){
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return -1;
    }

    //with duplicates
    static int findPivotwithduplicate(int[] nums){
        int start=0; 
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
    public static int BinarySearch(int[] nums, int target,int start,int end){

        while (start<=end){
            //int mid = (start+end)/2 This may exceed the int range , so we can use below equation
            int mid = start + (end - start)/2;
            if (target < nums[mid]) {
                end = mid - 1;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
                return mid;
            } 
        }
        return -1;
    }
}
