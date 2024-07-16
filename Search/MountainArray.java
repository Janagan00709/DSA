package Search;

public class MountainArray {
    public static void main(String[] args) {
        
    }
    public int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = ogbs(arr,target,0,peak);
        if (firstTry != -1) {
            return firstTry;
        }
        //Try to search in second half
        return ogbs(arr, target,peak+1,arr.length-1);

    }
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end = arr.length-1;
        while (start < end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in dec part of array
                //This may be the ans, but look at left
                //this is way end ! = mid -1
                end=mid;
            }else if(arr[mid]<arr[mid+1]){
                //you are in asc part of array
                start=mid+1;// because we know that mid+1 element > mid element
            }
            // In the end, start== end and pointing to largest number because of the 2 checks above 3
            //start and end are always trying to find max element in the above 2 checks
            // Hence, when they are pointing to just one element, that is the max one because that is what the checks say
            //More elaboration: at every point of time for start and end, they have the best possible answer till that time
            // And if we are saying that only one item is remaining, hence cuz of above line that is best possible answer
        }
        return start; 
    }
    static int ogbs(int[] arr, int target,int start,int end) {
        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            // int mid = (start+end)/2 This may exceed the int range , so we can use below
            // equation
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                }
                else if (target > arr[mid]) {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                }
                else if (target < arr[mid]) {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
