class Solution {
    int dp[];
    public int climbStairs(int n) {

        if(n==1) return 1;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n);
    }
    public int rec(int n){
        if(n<0){
            return 0;
        }
        if(n==0) return 1;

        if(dp[n]!=-1) return dp[n];

        int ways = 0;
        ways += rec(n-1);
       ways += rec(n-2);
       return dp[n] = ways;
    }
}
