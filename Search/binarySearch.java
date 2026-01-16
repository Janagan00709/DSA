package Search;
// import java.util.Arrays;
public class binarySearch {
    public static void main(String[] args) {
        // for sorting the array
        // int[] arr1={3,2,3,23,2,1};
        // Arrays.sort(arr1);
        // for(int num:arr1){
        //     System.out.print(num+" ");
        // }
        int[] arr = {-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int target=22;
        int ans=BinarySearch(arr,target);
        System.out.println(ans);
        System.out.println(arr[ans]);
    }
    public static int BinarySearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            //int mid = (start+end)/2 This may exceed the int range , so we can use below equation
            int mid = start + (end - start)/2;
            if (target < arr[mid]) {
                end = mid - 1;
            }else if (target > arr[mid]) {
                start = mid + 1;
            }else {
                return mid;
            } 
        }
        return -1;
    }
}
