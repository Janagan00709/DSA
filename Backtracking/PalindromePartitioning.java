package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(str, 0, path, result);
        
    }
    public static void solve(String str, int index, List<String> path, List<List<String>> result){
        if(index == str.length()){
            result.add(new ArrayList<>(path));
            System.out.println(result);
            return;
        }

        for(int i=index; i<str.length(); i++){
            if(isPalindrome(str, index, i)){
                path.add(str.substring(index, i+1));
                solve(str, i+1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String str, int start, int end){
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}