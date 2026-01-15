package Basics;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class DijkstraAlgorithm {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.weight - y.weight);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) (1e9);
        }
        dist[S] = 0;
        pq.add(new Pair(S, 0));
        while (pq.size() != 0) {
            int node = pq.peek().node;
            int dis = pq.peek().weight;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int S = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        adj.get(0).add(new ArrayList<Integer>(Arrays.asList(1, 9)));
        adj.get(0).add(new ArrayList<Integer>(Arrays.asList(2, 6)));
        adj.get(0).add(new ArrayList<Integer>(Arrays.asList(3, 5)));
        adj.get(0).add(new ArrayList<Integer>(Arrays.asList(4, 3)));

        adj.get(2).add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        adj.get(2).add(new ArrayList<Integer>(Arrays.asList(3, 4)));

        int[] res = dijkstra(V, adj, S);
        System.out.println(Arrays.toString(res));
    }
}
