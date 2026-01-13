// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class CombinationSumProblem {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        ArrayList<Integer> ans = new ArrayList<>();
        combinationsum(0,target,arr,ans);
    }
    public static void combinationsum(int index,int target,int[] arr,ArrayList<Integer> ans){
        if(index==arr.length){
            if(target==0){
                System.out.println(ans);
                return;
            }else{
                return;
            }
        }
        if(arr[index]<=target){
            ans.add(arr[index]);
            combinationsum(index,target-arr[index],arr,ans);
            ans.remove(ans.size()-1);
        }
        combinationsum(index+1,target,arr,ans);
    }
}
