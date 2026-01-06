package GreedyAlgorithm;

import java.util.*;

class Nmeetingroom {
    //Sorting based on end
    static class ItemComparator implements Comparator<Pair> {
        public int compare(Pair val1, Pair val2) {
            if(val1.end != val2.end) {
                return Integer.compare(val1.end, val2.end);
            }else{
                return Integer.compare(val1.start, val2.start);
            } 
        }
    }
    static class Pair{
        int start;
        int end;
        int pos;
        Pair(int start,int end,int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
    public static void main(String[] args) {
        int[] start = {0,3,1,5,5,8};
        int[] end = {5,4,2,9,7,9};
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            list.add(new Pair(start[i],end[i],i));
        }
        Collections.sort(list,new ItemComparator());
        int freetime = list.get(0).end;
        int count = 1;
        List<Integer> position = new ArrayList<>();
        position.add(list.get(0).pos);
        System.out.println("f0 "+freetime);
        for(int i=1;i<start.length;i++){
            if(list.get(i).start > freetime){
                count++;
                freetime = list.get(i).end;
                System.out.println("f"+i+": "+freetime);
                position.add(list.get(i).pos);
            }
        }
        System.out.println("Maximum number of meeting: "+count );
        System.out.println("Positions(1-based): ");
        for(int i=0;i<position.size();i++){
            System.out.print(position.get(i)+1+" ");
        }
    }
}
