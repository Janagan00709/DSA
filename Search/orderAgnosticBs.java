package Search;

public class orderAgnosticBs {
    public static void main(String[] args) {
        int[] arr = { 32, 29, 25, 15, 13, 7, 5, 4, 3, 2 };
        int ans = ogbs(arr, 2);
        System.out.println(ans);
    }

    static int ogbs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
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
