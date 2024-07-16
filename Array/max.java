package Array;
public class max {
    public static void main(String[] args) {
        int[] arr={10,2,3,4,9,23,34,234,31,424,234,54,24};
        System.out.println(Max(arr));
        System.out.println(min(arr));
    }
    public static int Max(int []arr){
        int max=arr[0];
        for(int i=0; i<arr.length;i++){
            if(max < arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    public static int min(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }
}

