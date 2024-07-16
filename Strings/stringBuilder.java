package Strings;
import java.util.*;
public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch).append(" ");
        }
        System.out.println(builder.toString()); // Output: a b c
        //builder.charAt(0);
        builder.reverse() ;
        System.out.println("The reversed string is");
        System.out.println(builder);

        // String
        String name = "Janagan";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name.indexOf('a'));
        System.out.println("   Janagan   ".strip());
        String  str1="Hello World!";
        System.out.println(Arrays.toString(str1.split(" ")));
    }
}
