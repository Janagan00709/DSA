package Graph;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class DetectCycleUsingBFS {
    static class Pair {
        int currentNode;
        int parentNode;

        Pair(int currentNode, int parentNode) {
            this.currentNode = currentNode;
            this.parentNode = parentNode;
        }
    }

    public static boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            int node = q.peek().currentNode;
            int parent = q.peek().parentNode;
            q.remove();
            for (int adjacentNode : adj.get(node)) {
                if (vis[adjacentNode] == false) {
                    vis[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                } else if (parent != adjacentNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, V, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUsingBFS obj = new DetectCycleUsingBFS();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(1);
        adj.get(1).add(4);

        if (obj.isCycle(V, adj)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No Cycle detected");
        }
    }
}
