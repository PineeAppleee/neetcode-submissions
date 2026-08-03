class pair {
    int a;
    int b;
    pair(int a, int b){
       this.a = a;
       this.b = b;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];
            adj.get(u).add(new pair(v, t));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.b - b.b);

         pq.add(new pair(k,0));
         int max[] = new int[n+1];
         Arrays.fill(max,Integer.MAX_VALUE);
         max[k] = 0;

         while(!pq.isEmpty()){
          int size = pq.size();

          for(int i = 0;i<size;i++){
            pair p = pq.poll();
            int u = p.a;
            int t = p.b;
            for(pair v : adj.get(u)){
             if(t+v.b<max[v.a]){
                max[v.a] = t+v.b;
                pq.add(new pair(v.a,t+v.b));
             }
            }
          }
         }
         int maxi = 0;
         for(int i = 1;i<n+1;i++){
            if(max[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxi = Math.max(maxi,max[i]);
         }

         return maxi;
    }
}
