package Graph;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class ShortestPathPrintUsingDijkstra {
    static class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    static List<Integer> dijkstra(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        int[] dis = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = (int) (1e9);
            parent[i] = i;
        }
        dis[1] = 0;
        pq.add(new Pair(0, 1));
        while (pq.size() != 0) {
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            if (dist > dis[node])
                continue;
            for (Pair it : adj.get(node)) {
                int adjNode = it.distance;
                int edgeWeight = it.node;
                if (dist + edgeWeight < dis[adjNode]) {
                    dis[adjNode] = dist + edgeWeight;
                    parent[adjNode] = node;
                    pq.add(new Pair(dis[adjNode], adjNode));
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dis[n] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int edges[][] = { { 1, 2, 2 }, { 1, 3, 4 }, { 2, 3, 1 }, { 2, 4, 7 }, { 3, 5, 3 }, { 4, 5, 1 } };
        List<Integer> res = dijkstra(n, m, edges);
        System.out.println(res);
    }
}
