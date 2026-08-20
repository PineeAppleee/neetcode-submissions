class Solution {

    Boolean dp[][];

    public boolean isMatch(String s, String p) {

        dp = new Boolean[s.length() + 1][p.length() + 1];

        return rec(0, 0, s, p);
    }

    public boolean rec(int i, int j, String s, String p) {

        if (i == s.length() && j == p.length())
            return true;

        if (j == p.length())
            return false;

        if (dp[i][j] != null)
            return dp[i][j];

        boolean curr = false;

        if (i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                boolean pick = rec(i + 1, j, s, p);
                boolean notpick = rec(i, j + 2, s, p);
                curr = pick || notpick;

            } else {
                curr = rec(i + 1, j + 1, s, p);
            }

        } else {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

                curr = rec(i, j + 2, s, p);
            }
        }

        return dp[i][j] = curr;
    }
}