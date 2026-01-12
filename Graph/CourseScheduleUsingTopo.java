package Graph;

import java.util.*;

class CourseScheduleUsingTopo {
    // Course Schedule I
    public static boolean courseScheduleOne(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            System.out.println(prerequisites[i][0] + "->" + prerequisites[i][1]);
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            topo[i++] = node;
            // System.out.println(node);
            q.remove();
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (topo.length < V) {
            return false;
        } else {
            return true;
        }
    }
    // Course Schedule II
    public static int[] findorder(int numCourses, int[][] prerequisites) {   
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            topo[i++] = node;
            // System.out.println(node);
            q.remove();
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (topo.length < numCourses) {
            return new int[0];
        } else {
            return topo;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        boolean res = courseScheduleOne(V, prerequisites);
        System.out.println(res);
        System.out.println(Arrays.toString(findorder(V, prerequisites)));
    }
}
