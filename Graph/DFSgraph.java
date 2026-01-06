package Graph;

import java.util.*;

public class DFSgraph {
    
    // DFS method
    public void dfs(int node, List<Integer>[] adj, boolean[] visited, List<Integer> result) {
        // Mark the current node as visited
        visited[node] = true;
        
        // Add the current node to the result
        result.add(node);
        
        // Recur for all the adjacent nodes
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        // Adjacency list
        List<Integer>[] adj = new ArrayList[V];
        
        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Adding edges
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0, 3));
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(1);
        adj[4].add(2);

        // Visited array
        boolean[] visited = new boolean[V];

        // Result list
        List<Integer> result = new ArrayList<>();

        // Create object of DFSGraph class
        DFSgraph sol = new DFSgraph();

        // Run DFS from node 0
        sol.dfs(0, adj, visited, result);

        // Print the traversal result
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
