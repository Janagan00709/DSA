package Graph;

import java.util.*;

class NoOfProvinces {
    // Function to perform DFS traversal
    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        // Mark the current node as visited
        visited[node] = true;

        // Visit all adjacent unvisited nodes -> it = neighbor node
        for (int it : adjList.get(node)) {
            if (!visited[it]) {
                dfs(it, adjList, visited);
            }
        }
    }

    // Function to count number of provinces
    public int numProvinces(int[][] adj, int V) {
        // Create adjacency list from adjacency matrix
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Convert matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Ignore self loops
                if (adj[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        // Visited array to track visited nodes
        boolean[] visited = new boolean[V];

        // Count of provinces
        int count = 0;

        // Traverse all nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Start DFS and increment count
                count++;
                dfs(i, adjList, visited);
            }
        }

        return count;
    }
}

// Main class to run the program
public class Provinces {
    public static void main(String[] args) {
        // Input adjacency matrix
        int[][] adj = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        };

        // Number of vertices
        int V = 3;

        // Create object of NoOfProvinces class
        NoOfProvinces ans = new NoOfProvinces();

        // Call function and print result
        System.out.println(ans.numProvinces(adj, V));
    }
}

