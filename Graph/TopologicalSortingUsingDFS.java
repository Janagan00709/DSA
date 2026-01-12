package Graph;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class TopologicalSortingUsingDFS {
    public static void dfs(int node,int[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }
    public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i<V ;i++){
            dfs(i,vis,st,adj);
        }
        int ans[] = new int[V+1];
        int i=0;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        int[] res = topoSort(V,adj);
        for(int i : res){
            System.out.print(i+" ");
        }
    }
}
