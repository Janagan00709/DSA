package Strings;
import java.util.*;
public class Sample {
    public static void main(String[] args) {
        String name = "Janagan";
        System.out.println("Hello, "+name);
        String a = "Captain america";
        String b = "Captain america";

       
        // a="steve";
        System.out.println("The value of a is "+a);
        System.out.println("The value of b is "+b);
        System.out.println("Using only String method: ");
         System.out.println(a==b);

        // Creating two different object with same value

        String name1 = new String("IronMan");
        String name2 = new String("IronMan");
        System.out.println("Name1: "+name1);
        System.out.println("Name2: "+name2);
        System.out.println("Using new key word method:");
        System.out.println(name1==name2);  // false
        System.out.println("Using equals() method:");
        System.out.println(name1.equals(name2));   // true
        System.out.println(name1.charAt(0));

        // Float 
        float f1=453.1274f;
        System.out.printf("The formatted output is %.2f",f1);
        System.out.printf("\nPie : %.3f \n",Math.PI);

        // Character
        System.out.println('a'+'b');
        System.out.println((char)('a'+3));
        System.out.println((char)(65));
        /*
         * System.out.println("a"+1);
         * this is same as after a few steps: "a" + "1"
         * Integer will be converted to Integer that will call toString()
        */
        System.out.println("Janagan"+ new ArrayList<>());
        //System.out.println("Janagan" + new Integer(50));

        // we can add array and Integer , if we want to any one can be string type
        //System.out.println(new Integer(56)+""+new ArrayList<>());
        
    }
}
