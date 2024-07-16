import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {13,15,5,4,3,14,2,1,8,7,6,9,12,11,10};
        int[] arr1 = mergeSort(arr);
        System.out.println(Arrays.toString(arr1));
    }
    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right= mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }
    private static int[] merge(int[] first,int[] second){
        int[] mix = new int[first.length + second.length];
        int i=0,j=0,k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        //It may be a possible that one of the array is not complete
        //copy remaining elements
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
}
