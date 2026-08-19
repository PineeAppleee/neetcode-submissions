class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return rec(word1, word2, 0, 0);
    }
    public int rec(String word1, String word2, int i, int j) {
        if (i == word1.length())
            return word2.length() - j;

        if (j == word2.length())
            return word1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];
        int notpick = Integer.MAX_VALUE;
        int pick = Integer.MAX_VALUE;
        if (word1.charAt(i) == word2.charAt(j)) {
            notpick = rec(word1, word2, i + 1, j + 1);
        } else {
            int opr = 0;
            int delete = 1 + rec(word1, word2, i + 1, j);
            int insert = 1 + rec(word1, word2, i, j + 1);
            int replace = 1 + rec(word1, word2, i + 1, j + 1);
            pick = Math.min(pick,Math.min(delete,Math.min(insert,replace)));
        }
        return dp[i][j] = Math.min(pick, notpick);
    }
}
