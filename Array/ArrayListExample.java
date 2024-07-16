package Array;
import java.util.*;
public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        // Adding elements to the arraylist
        // list.add(67);
        // list.add(34);
        // list.add(43);
        // list.add(56);
        // list.add(78);
        // list.add(4533);
        // list.add(455);
        // list.add(454);
        // list.add(7);
        // list.add(4);
        // list.add(5);
        // System.out.println("Original List: \n" + list);
        // System.out.println(list.contains(5));
        // list.set(4,79);
        // System.out.println(list);
        // System.out.println("After remove index 3:");
        // list.remove(3);
        // System.out.println(list);

        //input
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<5;i++){
            int num=sc.nextInt();
            list.add(num);
        }
        System.out.println(list);
        sc.close();
    }
}
