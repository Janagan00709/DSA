package HashMap;

import java.util.*;

public class CheckOccurrences {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "apple", "orange", "banana"};
        int k = 2;
        System.out.println(checkOccurrences(array, k));
    }

    public static String checkOccurrences(String[] array, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : array) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        boolean found = countMap.values().contains(k);
        return found ? "True" : "False";
    }
}

