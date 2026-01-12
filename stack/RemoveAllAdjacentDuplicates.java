package stack;

// Remove All Adjacent Duplicates
import java.util.*;
class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        String str = "azxxzy";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(!stack.isEmpty() && stack.peek()==str.charAt(i)){
                stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans  = stack.pop() + ans ;
        }
        System.out.println(ans);
    }
}
