class Solution {
    HashMap<String, Character> mp = new HashMap<>();
    int dp[];
    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            char ch = (char) ((i - 1) + 'A');
            String str = Integer.toString(i);
            mp.put(str, ch);
        }

        dp = new int[s.length()];
        Arrays.fill(dp,-1);

        return dfs(s, 0);
    }

    public int dfs(String s, int idx) {
        if (idx == s.length())
            return 1;
        if (idx > s.length())
            return 0;

        if(dp[idx]!=-1) return dp[idx];

        int ways = 0;
        for (int i = idx; i < Math.min(idx + 2, s.length()); i++) {
            if (mp.containsKey(s.substring(idx, i + 1))) {
                ways += dfs(s, i+1);
            }
        }
        return dp[idx]= ways;
    }
}
