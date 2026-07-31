class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }
        int visited[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(visited[i]==0){
              if(detectcycle(i,adj,visited)==true) return false;
            }
          
        }
        return true;
    }
    public boolean detectcycle(
        int u, ArrayList<ArrayList<Integer>> adj, int visited[]) {
        visited[u] = 1;

        for (int v : adj.get(u)) {

            if (visited[v] == 0) {
                if (detectcycle(v, adj, visited)) {
                    return true;
                }
            }
            else if (visited[v] == 1) {
                return true;
            }
        }
         visited[u]=2;
        return false;
    }
}
