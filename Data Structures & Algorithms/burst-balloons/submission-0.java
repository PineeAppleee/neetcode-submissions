class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {


        int n = nums.length;

        int[] arr = new int[n + 2];
        dp = new Integer[arr.length+1][arr.length+1];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }

        return rec(arr, 1, n);
    }
    public int rec(int[] nums, int i, int j) {
        if (i > j)
            return 0;
         if(dp[i][j]!=null) return dp[i][j];
        int pick = 0;
        for (int k = i; k <= j; k++) {
            int ans = (nums[i-1] * nums[k] * nums[j + 1])
                +rec(nums, i, k-1)+rec(nums,k+1, j);
            pick = Math.max(pick, ans);
        }
        return dp[i][j] = pick;
    }
}
