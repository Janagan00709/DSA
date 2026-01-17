package GreedyAlgorithm;

import java.util.*;
class chef {
    static class itemComparator implements Comparator<Pair>{
        public int compare(Pair firstvalue, Pair secondvalue){
            if(firstvalue.val2 != secondvalue.val2){
                return Integer.compare(firstvalue.val2,secondvalue.val2);
            }else{
                return Integer.compare(firstvalue.val1,secondvalue.val1);
            }
        }
    }
    static class Pair{
        int val1;
        int val2;
        Pair(int val1,int val2){
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read initial complexity
        System.out.println("Enter initial complexity C:");
        int C = sc.nextInt();
        System.out.println("Enter number of chefs N:");
        // Read number of chefs
        int N = sc.nextInt();

        int[][] chefs = new int[N][2];

        // Read expertise and messiness of each chef
        for(int i = 0; i < N; i++){
            chefs[i][0] = sc.nextInt();   // expertise e
            chefs[i][1] = sc.nextInt();   // messiness m
        }

        // ---- YOUR LOGIC HERE ----
        // Example:
        int result = solve(C, chefs);
        System.out.println(result);

        sc.close();
    }

    // You can implement your logic inside this method
    public static int solve(int C, int[][] chefs){
        // Write your greedy solution here
        List<Pair> list = new ArrayList<>();
        // for(int i=0;i<chefs.length;i++){
        //         list.add(new Pair(chefs[i][0],chefs[i][1]));
        // }
        Collections.sort(list,new itemComparator());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).val1 + " "+ list.get(i).val2);
        }
        int count = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).val1 >= C){
                count++;
                C = Math.max(C,list.get(i).val2);
            }
        }
        return count;

    }
}

