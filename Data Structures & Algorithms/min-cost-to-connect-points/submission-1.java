class DSU{
    int[] parent, size;
    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 0; i<=n; i++) parent[i] = i;
        Arrays.fill(size, 1);
    }

    public int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u) , pv = find(v);
        if(pu==pv) return false;
        if(size[pu] < size[pv]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] += size[pv];
        parent[pv] = pu;
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        }
        edges.sort((a,b)-> Integer.compare(a[0], b[0]));
        int res = 0;

        for(int[] edge : edges){
            if(dsu.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }
        return res;
    }
}
