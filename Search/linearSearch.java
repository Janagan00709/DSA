package Search;

import java.util.*;

public class linearSearch {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array element upto 10 elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element you want to search:");
        int n = sc.nextInt();
        linearsearch(arr, n);
        linearsearch(arr,n,2,5);
        sc.close();
    }

    public static void linearsearch(int[] arr, int n){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                System.out.println(n+" is present in given array in index: "+i);
            }
        }
    }
    public static void linearsearch(int[] arr, int n,int start,int end){
        if(arr.length==0){
            return;
        }
        for(int i=start;i<=end;i++){
            if(arr[i]==n){
                System.out.println(n+" is present in given array in index: "+i);
            }
        }
    }
}
