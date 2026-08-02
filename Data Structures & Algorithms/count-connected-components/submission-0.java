class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int count = 0;
       int visited[] = new int[n];
        for(int i = 0;i<n;i++){
            if(visited[i]==0){
                dfs(adj,i,visited);
                count++;
            }
        }
        return count;

    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int u, int visited[]) {
        visited[u] = 1;
        for (int v : adj.get(u)) {
            if (visited[v] == 0) {
                dfs(adj, v, visited);
            }
        }
    }
}
