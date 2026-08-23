class Solution {
    int dp[];
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return rec(nums,0);
    }

    public int rec(int[] nums, int i){
        if(i==nums.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int end = Math.min(i+nums[i],nums.length-1);
        int min = 2000;
        for(int j = i+1;j<=end;j++){
         int ans = 1+rec(nums,j);
         min = Math.min(min,ans);
        }
        return dp[i] = min;
    }
}
