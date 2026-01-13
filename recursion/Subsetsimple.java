import java.util.*;

public class Subsetsimple {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        System.out.println(result);
    }

    public static void solve(int index, int[] nums, List<Integer> list, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        // include
        list.add(nums[index]);
        //System.out.print("include ");
        //System.out.println(list);
        solve(index + 1, nums, list, result);
        list.remove(list.size() - 1);

        // exclude
        //System.out.println("Exclude " + list);
        solve(index + 1, nums, list, result);
        
    }
}
