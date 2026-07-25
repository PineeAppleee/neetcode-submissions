class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        rec(board, 0);
        return res;
    }

    public void rec(char board[][],int r){
        if(r==board.length){
            List<String> list = new ArrayList<>();
            for(int k = 0;k<board.length;k++){
                String str = new String(board[k]);
                list.add(str);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int c = 0;c<board.length; c++){
            if(issafe(r, c, board)){
            board[r][c] = 'Q';
            rec(board,r+1);
            board[r][c] = '.';
            }
        }
        

    }

   private boolean issafe(int r, int c, char[][] board) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
