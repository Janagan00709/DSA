package DynamicProgramming;

import java.util.ArrayList;

class subset {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int target = 4;

        Boolean[][] dp = new Boolean[n][target + 1];
        boolean ans1 = subsetUsingDP(n - 1, target, arr, dp);
        System.out.println(ans1);
        boolean ans2 = subsetUsingrecursive(n - 1, target, arr);
        System.out.println(ans2);
        boolean ans = subsetUsingTabulation(n - 1, target, arr);
        System.out.println(ans);
        subsetGeneratorUsingdp(0,arr,new ArrayList<>());
    }
    public static void subsetGeneratorUsingdp(int index,int[] arr,ArrayList<Integer> list) {
        if(index==arr.length){
            System.out.println(list);
            return;
        }
        for(int j=index;j<=index;j++){
            list.add(arr[j]);
            subsetGeneratorUsingdp(index+1,arr,list);
            list.remove(list.size()-1);
            subsetGeneratorUsingdp(index+1,arr,list);
        }
    }
    public static boolean subsetUsingTabulation(int n, int target, int[] arr) {

        boolean[][] dp = new boolean[n][target + 1];

        // Base case: sum = 0 always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // First element initialization
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 1; tar <= target; tar++) {

                boolean notTake = dp[ind - 1][tar];
                boolean take = false;

                if (arr[ind] <= tar) {
                    take = dp[ind - 1][tar - arr[ind]];
                }

                dp[ind][tar] = take || notTake;
            }
        }

        return dp[n - 1][target];
    }

    public static boolean subsetUsingDP(int ind, int target, int[] arr, Boolean[][] dp) {

        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;

        if (dp[ind][target] != null)
            return dp[ind][target];

        boolean notTake = subsetUsingDP(ind - 1, target, arr, dp);

        boolean take = false;
        if (arr[ind] <= target) {
            take = subsetUsingDP(ind - 1, target - arr[ind], arr, dp);
        }

        dp[ind][target] = take || notTake;
        return dp[ind][target];
    }

    // Normal recursive version (without DP)
    public static boolean subsetUsingrecursive(int ind, int target, int[] arr) {

        if (target == 0) return true;
        if (ind == 0) return arr[0] == target;

        boolean notTake = subsetUsingrecursive(ind - 1, target, arr);

        boolean take = false;
        if (arr[ind] <= target) {
            take = subsetUsingrecursive(ind - 1, target - arr[ind], arr);
        }

        return take || notTake;
    }
}
