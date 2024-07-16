package Array;
import java.util.Arrays;
import java.util.Scanner;
public class sample {
    public static void main(String[] args) {
        // int a=19;
        // String name="Janagan";
        // Q : Store 5 roll numbers
        // int rollno1=23;
        // int rollno2=45;
        // int rollno3=24;
        
        //syntax
        //datatype[] variable_name = new datatype[size];
        //Store 5 roll number;
        // int[] rollno =new int [5];
        // or directly 
        // int[] roll={23,45,24};

        int[] ros;  // Declaration of  array, ros is getting defined in the stack
        ros=new int[5];// Initialization :  Actually here object is being created in the memory (heap)
        System.out.println(ros[1]);
        String[] arr = new String[4];
        System.out.println(arr[1]);

        //Array
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[5];
        System.out.println("Enter any 5 digit numbers:");
        for(int i=0;i<arr1.length;i++){
            arr1[i]=sc.nextInt();
        }
        change(arr1);
        // For each loop to print output
        for(int num : arr1){ // For every element in array , print the elements
            System.out.print(num + " ");
        }
        System.out.println();
        String[] str = new String[4];
        System.out.println("Enter any five strings:");
        for(int i=0; i< str.length; i++){
            str[i]=sc.next();
        }
        System.out.println(Arrays.toString(str));

        str[1]="Janagan";
        System.out.println(Arrays.toString(str));
        sc.close();
    }
    static void change(int[] arr2){
        arr2[0]=22;
    }
}
