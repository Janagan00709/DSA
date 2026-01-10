package Graph;

import java.util.*;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        System.out.println("Adjacency Matrix and Adjacency List Representation");
        matrix();
        Arraylist();

    }

    static void matrix() {
        int n = 3, m = 3;
        int u = 1, v = 2;
        int[][] adj = new int[n][m];
        // edge 1--2
        adj[1][2] = 1;
        adj[2][1] = 1;

        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    static void Arraylist() {
        int n = 3;
        // int m=3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        // n+1
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // edge 1--2
        adj.get(1).add(2);
        adj.get(2).add(1);
        // print all the edges
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
