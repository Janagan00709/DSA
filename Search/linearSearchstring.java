package Search;
import java.util.*;
public class linearSearchstring {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a string:");
        String name = sc.next();
        System.out.println("Enter the character to find the string:");
        char target=sc.next().charAt(0);
        //sout(Arrays.toString(name.toCharArray()));
        linearSearch(name,target);
        linearSearch2(name,target);
        sc.close();
    }
    public static void linearSearch(String str, char target){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==target){
                System.out.println("The character " + target + " is found at index "+i+" in the given string.");
            }
        }
    }
    public static boolean linearSearch2(String str, char target){
        for(char ch :  str.toCharArray()){
            if(ch == target){
                return true;
            }
        }
        return false;
    }

}
