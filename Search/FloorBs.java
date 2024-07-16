package Search;

//Floor -> Greatest smaller number in the array is lesser than or equal to target
public class FloorBs {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 9, 14, 16, 18 };
        int target = 15;
        int ans = Floor(arr, target);
        System.out.println("In the index:" + ans);
        System.out.println("The floor element is " + arr[ans]);
    }

    // return the index of greaster no < = target
    public static int Floor(int[] arr, int target) {

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
        return end;
    }
}
