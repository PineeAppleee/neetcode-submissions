class Solution {

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // First and last column
        for(int i=0;i<n;i++){

            if(board[i][0]=='O'){
                board[i][0]='#';
                q.offer(new int[]{i,0});
            }

            if(board[i][m-1]=='O'){
                board[i][m-1]='#';
                q.offer(new int[]{i,m-1});
            }
        }

        // First and last row
        for(int j=0;j<m;j++){

            if(board[0][j]=='O'){
                board[0][j]='#';
                q.offer(new int[]{0,j});
            }

            if(board[n-1][j]=='O'){
                board[n-1][j]='#';
                q.offer(new int[]{n-1,j});
            }
        }

        while(!q.isEmpty()){

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];

            for(int[] d:dir){

                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='O'){

                    board[nr][nc]='#';
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(board[i][j]=='O')
                    board[i][j]='X';

                else if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
}