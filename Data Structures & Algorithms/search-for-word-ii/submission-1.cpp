class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> res;


        int n = board.size();
        int m = board[m].size();

        for(string& word : words){

          bool flag = false;
        for(int i = 0;i<n && !flag;i++){
          for(int j = 0;j<m;j++){
           
           if(board[i][j]!=word[0]) continue;

           if(dfs(board,i,j,word,0)){
            res.push_back(word);
            flag = true;
            break;
           }
          }
        }
        }

        return res;
    }

    private:
       bool dfs(vector<vector<char>>& board,int r, int c, string& word, int i){
        if(i==word.length()) return true;

        if(r<0 || c<0 || r>=board.size() || c>= board[0].size() || 
         board[r][c] != word[i]) return false;

         board[r][c] = '*';
         bool ret = dfs(board, r + 1, c, word, i + 1) ||
                  dfs(board, r - 1, c, word, i + 1) ||
                   dfs(board, r, c + 1, word, i + 1) ||
                   dfs(board, r, c - 1, word, i + 1);
          
          board[r][c] = word[i];
          return ret;

       }
};
