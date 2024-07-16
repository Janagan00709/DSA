package Queue;
import java.util.*;
public class inbuiltqueue{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();  
        q.add(3);
        q.add(6);
        q.add(5);
        q.add(19);
        q.add(1);
        System.out.println("The first element is "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());

        System.out.println("Deque"); 
        Deque<Integer> d=new ArrayDeque<>();
        d.add(89);
        d.addLast(78);
        d.removeFirst();



    }
}
