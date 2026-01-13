import java.util.*;
class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSum(0,0,ans,arr);
        Collections.sort(ans);
        System.out.println(ans);
    }
    public static void subsetSum(int index,int sum,ArrayList<Integer> ans,int[] arr){
        if(index==arr.length){
            ans.add(sum);
            return;
        }
        subsetSum(index+1,sum+arr[index],ans,arr);
        subsetSum(index+1,sum,ans,arr);
    }
}
