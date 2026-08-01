class Solution {
    public boolean validTree(int n, int[][] edges) {
      if (edges.length != n - 1)
        return false;

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0;i<n;i++){
        adj.add(new ArrayList<>());
    }

    for(int i = 0;i<edges.length;i++){
        int u = edges[i][0];
        int v = edges[i][1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    return !isCycle(n,adj);
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V];

    if (dfs(0, -1, vis, adj))
        return true;

    for (int i = 0; i < V; i++) {
        if (!vis[i])
            return true;
    }

    return false;
}

    boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, node, vis, adj))
                    return true;

            } else if (neighbour != parent) {
                return true;
            }
        }

        return false;
    }
}
