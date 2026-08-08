class Solution {
    Integer dp[][];
    public int coinChange(int[] coins, int amount) {
       dp = new Integer[coins.length][amount+1];
        return (
            rec(coins, amount, 0) != Integer.MAX_VALUE ? rec(coins, amount, 0) : -1);
    }
    public int rec(int[] coins, int amount, int idx) {
        if (amount == 0)
            return 0;
        if (idx >= coins.length)
            return Integer.MAX_VALUE;
        if(dp[idx][amount]!=null) return dp[idx][amount];
        int pick = Integer.MAX_VALUE;
        if (coins[idx] <= amount) {
            int ans = rec(coins, amount - coins[idx], idx);
            if (ans != Integer.MAX_VALUE) {
                pick = 1 + ans;
            }
        }
        int notpick = rec(coins, amount, idx + 1);
        return dp[idx][amount] = Math.min(pick, notpick);
    }
}
