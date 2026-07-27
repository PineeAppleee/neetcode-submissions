class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
      int count = 0;
      vector<vector<bool>> visited(grid.size(), vector<bool>(grid[0].size(), false));
        for(int i = 0;i< grid.size(); i++){
          for(int j = 0;j< grid[0].size();j++){
            if(grid[i][j] == '1'&&visited[i][j]==false){
              dfs(i,j,grid,visited);
              count++;
            }
          }
        }
        return count;
    }

  private:
     void dfs(int i,int j, vector<vector<char>>& grid, vector<vector<bool>>& visited){
      if(i<0 || j<0 || i>=grid.size() || j>= grid[0].size() || visited[i][j] == true
      || grid[i][j] == '0'){
        return;
      }
       
       visited[i][j] = true;
       dfs(i,j-1,grid,visited);
       dfs(i,j+1,grid,visited);
       dfs(i+1,j,grid,visited);
       dfs(i-1,j,grid,visited);

     }
};
