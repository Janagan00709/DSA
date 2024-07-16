package stack;
import java.util.*;

public class minAddToMakeValid {
    public static void main(String[] args) {
        System.out.println(MinAddToMakeValid("(())"));
    }
    public static int MinAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size();

    }
}
