package Search;

// import java.util.Arrays;
//Ceiling -> Smallest element in array greater than or equal to target
public class smallestNumber {
    public static void main(String[] args) {
        char[] arr ={'c','f','j'};
        System.out.println("The ceiling element is " + Ceiling(arr,'j'));
    }

    public static char Ceiling(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            // int mid = (start+end)/2 This may exceed the int range , so we can use below
            // equation
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }  
        }
        return letters[start % letters.length];
    }
}
