package Array;

// Mr cooper company question
import java.util.*;

public class weekpwd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to verify weak password or not");
        int num = sc.nextInt();
        String str = Integer.toString(num);
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                System.out.println("Weak password");
                sc.close();
                return;
            }
        }
        System.out.println("Strong Password");
        sc.close();
    }
}