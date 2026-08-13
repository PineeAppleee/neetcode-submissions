class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int row[] : dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        return rec(prices, 0, 0);
    }
    public int rec(int[] prices, int idx, int toggle) {
        if (idx >= prices.length) {
            return 0;
        }
        if(dp[idx][toggle]!=Integer.MIN_VALUE) return dp[idx][toggle];
        int pick =rec(prices,idx+1,toggle);

        if (toggle == 0) {
            int buy = -prices[idx] + rec(prices, idx + 1, 1);
            pick = Math.max(buy, pick);
        } else {
            int sell = prices[idx] + rec(prices, idx + 2,0);
            pick = Math.max(sell, pick);
        }
        return dp[idx][toggle]=pick;
    }
}
