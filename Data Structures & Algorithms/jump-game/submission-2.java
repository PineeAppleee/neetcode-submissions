class Solution {
    Boolean dp[];
    public boolean canJump(int[] nums) {
         dp = new Boolean[nums.length];
        return dfs(nums,0);
    }
    public boolean dfs(int[] nums,int i){
        if(i==nums.length-1) return true;
        if(dp[i]!=null) return dp[i];
        int end = Math.min(nums.length-1, i + nums[i]);

        for(int j = i+1; j<= end; j++){
            if(dfs(nums,j)) return true;
        }

        return dp[i] = false;
    }
}
