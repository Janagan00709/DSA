package Search;
//Amazon question
public class InfinitesortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,9,10,90,100,130,140,160,170,190,200,250,270,290,300,310,320,330,400};
        int target = 200;
        System.out.println(ans(arr, target));
    }
    static int ans(int[] arr,int target){
        // First find the range
        //start with the box of size 2
        int start=0;
        int end =1;
        // condition for the target to lie in the range
        while(target > arr[end]){
            int newstart = end +1 ; // newstart -> temp
            //DOUBLE THE BOX VALUE
            // END = PREVIOUS END + SIZEBOX + 2
            end = end+(end - start + 1)*2;
            start = newstart;
        }
        return BinarySearch(arr, target, start, end);

    }
    public static int BinarySearch(int[] arr, int target,int start,int end){
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
