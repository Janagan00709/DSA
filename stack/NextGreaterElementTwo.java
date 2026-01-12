package stack;
// Next Greater Element II
// In a circular array, the next greater element for an element x is the first greater element on its traversing-order next in the array, which means you could search circularly to find its next greater element.
// If it doesn't exist, output -1 for this number.
// int[] arr = {1,2,1,1,2,1} for imagination of circular array but only given arr = {1,2,1}
import java.util.*;
public class NextGreaterElementTwo {
    public static void main(String[] args) {
        int[] arr= {1,2,1};
        int[] nge = new int[arr.length];
        int N = arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*arr.length - 1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i%N]){
                stack.pop();
            }
            if(i<N){
                nge[i]  = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[i%N]);
        }
        System.out.println(Arrays.toString(nge));
    }
    
}
