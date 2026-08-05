class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k)
                continue;

            for (int[] next : adj.get(node)) {

                int neighbour = next[0];
                int price = next[1];

                if (cost + price < dist[neighbour]) {

                    dist[neighbour] = cost + price;

                    q.offer(new int[]{
                            neighbour,
                            cost + price,
                            stops + 1
                    });
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}