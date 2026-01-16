import java.util.*;

public class Subsetsimple {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        subsetsumforTarget(0, nums, new ArrayList<>(), result, 3);
        System.out.println(result);
        result.clear();
        solve(0, nums, new ArrayList<>(), result);
        System.out.println(result);
        sumsetSum(0, nums, new ArrayList<>(), new ArrayList<>(), 0);
    }
    public static void subsetsumforTarget(int index, int[] nums, List<Integer> list, List<List<Integer>> result, int target){
        if(index == nums.length){
            int sum = 0;
            for(int num : list){
                sum += num;
            }
            if(sum == target){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        // include
        list.add(nums[index]);
        //System.out.print("include ");
        //System.out.println(list);
        subsetsumforTarget(index + 1, nums, list, result, target);
        list.remove(list.size() - 1);

        // exclude
        //System.out.println("Exclude " + list);
        subsetsumforTarget(index + 1, nums, list, result, target);
        
    }
    public static void sumsetSum(int index, int[] nums, List<Integer> list, List<List<Integer>> result, int sum){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            System.out.println("Sum: " + sum + " Subset: " + list);
            return;
        }

        // include
        list.add(nums[index]);
        sum += nums[index];
        //System.out.print("include ");
        //System.out.println(list);
        sumsetSum(index + 1, nums, list, result, sum);
        list.remove(list.size() - 1);
        sum -= nums[index];

        // exclude
        //System.out.println("Exclude " + list);
        sumsetSum(index + 1, nums, list, result, sum);
        
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
