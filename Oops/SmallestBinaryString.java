package Oops;

import java.util.Scanner;

public class SmallestBinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        scanner.close();
        
        StringBuilder sb = new StringBuilder(S);
        boolean found;
        
        do {
            found = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '0') {
                    sb.deleteCharAt(i);  // Remove '1' at index i
                    found = true;
                    break;
                }
            }
        } while (found);
        
        System.out.println(sb.toString());
    }
}

