class Solution {
    int directions[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int dp[][];
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];

        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] maxi = new int[1];
        maxi[0] = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[n][m];

        rec(grid, 0, 0, n, m, 0, maxi, visited);

        return maxi[0];
    }

    public void rec(
        int[][] grid, int i, int j, int n, int m, int ans, int[] maxi, boolean[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j])
            return;

        if (ans >= dp[i][j])
            return;

        dp[i][j] = ans;

        ans = Math.max(ans, grid[i][j]);

        if (ans >= maxi[0]) // Pruning
            return;

        if (i == n - 1 && j == m - 1) {
            maxi[0] = Math.min(maxi[0], ans);
            return;
        }

        visited[i][j] = true;

        for (int[] dir : directions) {
            int row = i + dir[0];
            int col = j + dir[1];
            rec(grid, row, col, n, m, ans, maxi, visited);
        }

        visited[i][j] = false;
    }
}