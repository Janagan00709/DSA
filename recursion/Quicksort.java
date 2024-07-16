import java.util.*;
public class Quicksort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1,6,8,7,9,10,12,11,15,13,14};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        /*
         * Quick Sort
         *      |
         *      v
         * Arrays.sort(arr);
         */
    }
    static void sort(int[] nums,int low,int high){
        if(low >=high){
            return;
        }
        int s =low;
        int e=high;
        int m= s+(e-s)/2;
        int pivot =nums[m];

        while(s<=e){
            //also a reason why if its already sorted it will not swap
            while(nums[s]<pivot){
                s++;
            }
            while(nums[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp = nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
        //Now pivot is at crt index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, high);
    }
}
