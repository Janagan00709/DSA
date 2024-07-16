package Array;
import java.util.*;
public class multidimension {
    public static void main(String[] args) {
        // 2D array
        /*
         *  1 2 3
         *  4 5 6 
         *  7 8 9
        */
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        /*
         * int[][] arr = {
         *      {1,2,3}, // 0th index
         *      {4,5,6}, // 1st index
         *      {7,8,9}  // 2nd index 
         * }
        */
        System.out.println("Enter the elements for matrix 3 X 3:");
        for(int i=0; i <arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++ ) {
                //arr[row].length -> each row length
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i <arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++ ) {
                System.out.print(arr[i][j] + " " );
            }
            System.out.println();
        }
        /*     //We can also write in this form
         * for(int row=0;row>arr.length;row++){
         *       System.out.println(Arrays.toString(arr[row]));
         * }
        */
        System.out.println(arr[1][0]);
        // Enhanced for loop
        /*
         * for(int[] a : arr){
         *      System.out.println(Arrays.toString(a));
         * }
        */
        sc.close();
    }
}
