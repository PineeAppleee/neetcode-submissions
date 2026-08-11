class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
     int total = 0;
     for(int num : nums) total+=num;
     dp = new Boolean[nums.length][total+1];
     if(total%2!=0) return false;
     return rec(nums,0,total,0);
    }
    public boolean rec(int[] nums,int idx,int total,int sum){
        if(total/2 == sum){
            return true;
        }
        if(idx>=nums.length) return false;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        boolean pick = rec(nums,idx+1,total,sum+nums[idx]);
        boolean notpick = rec(nums,idx+1,total,sum);
        return dp[idx][sum] = pick||notpick;
    }
}
