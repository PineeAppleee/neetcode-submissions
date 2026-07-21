class pair {
    double a;
    int b;
    int c;

    pair(double a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<pair> pq =
                new PriorityQueue<>((x, y) -> Double.compare(y.a, x.a));

        int n = points.length;

        for (int i = 0; i < n; i++) {

            double dis = (points[i][0] * points[i][0]) +
                         (points[i][1] * points[i][1]);

            // Math.sqrt() is optional
            double eq_dis = Math.sqrt(dis);

            pq.add(new pair(eq_dis, points[i][0], points[i][1]));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {
            pair p = pq.poll();
            ans[i][0] = p.b;
            ans[i][1] = p.c;
            i++;
        }

        return ans;
    }
}