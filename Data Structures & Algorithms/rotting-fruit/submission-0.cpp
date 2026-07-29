class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        queue<pair<int, int>> q;
        int fresh = 0;

        // Count fresh oranges and push all rotten oranges into the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.push({i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0)
            return 0;

        vector<pair<int, int>> dirs = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };

        int minutes = 0;

        while (!q.empty()) {
            int size = q.size();
            bool rotted = false;

            while (size--) {
                auto [row, col] = q.front();
                q.pop();

                for (auto dir : dirs) {
                    int r = row + dir.first;
                    int c = col + dir.second;

                    if (r >= 0 && r < n && c >= 0 && c < m &&
                        grid[r][c] == 1) {

                        grid[r][c] = 2;
                        fresh--;
                        q.push({r, c});
                        rotted = true;
                    }
                }
            }

            // Increase time only if at least one orange rotted this minute
            if (rotted)
                minutes++;
        }

        return (fresh == 0) ? minutes : -1;
    }
};