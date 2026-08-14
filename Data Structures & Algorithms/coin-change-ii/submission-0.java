class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return rec(amount,coins,0);
    }
    public int rec(int amount,int[] coins,int idx){
        if(amount==0) return 1;
        if(idx>=coins.length) return 0;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int pick = 0;
        if(amount>=coins[idx]){
            pick = rec(amount-coins[idx],coins,idx);
        }
        pick += rec(amount,coins,idx+1);
        return dp[idx][amount] = pick;
    }
}
