package Search;

// import java.util.Arrays;
//Ceiling -> Smallest element in array greater than or equal to target
public class CeilingBs {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 9, 14, 16, 18 };
        int target = 15;
        int ans = Ceiling(arr, target);
        System.out.println("In the index:" + ans);
        System.out.println("The ceiling element is " + arr[ans]);
    }

    public static int Ceiling(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // int mid = (start+end)/2 This may exceed the int range , so we can use below
            // equation
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            }else if (target > arr[mid]) {
                start = mid + 1;
            }else {
                return mid;
            } 
        }
        return start;
    }
}
