package Search;

public class MountainPeak {
    public static void main(String[] args) {
        
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
        return start; // or end both are equal
    }
}
