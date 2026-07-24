class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rec(board, word, new StringBuilder(), i, j, n, m, 0, visited))
                    return true;
            }
        }

        return false;
    }
    public boolean rec(char[][] board, String word, StringBuilder str, int i, int j, int n, int m,
        int k, boolean visited[][]) {

         if(k==word.length()) return true;   
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || board[i][j] != word.charAt(k))
            return false;

        visited[i][j] = true;
        str.append(board[i][j]);

        boolean left = rec(board, word, str, i, j - 1, n, m, k+1, visited);
        boolean right = rec(board, word, str, i, j + 1, n, m, k+1, visited);
        boolean down = rec(board, word, str, i + 1, j, n, m, k+1, visited);
        boolean up = rec(board, word, str, i - 1, j, n, m, k+1, visited);

        str.deleteCharAt(str.length() - 1);
        visited[i][j] = false;
        return left || right || down || up;
    }
}
