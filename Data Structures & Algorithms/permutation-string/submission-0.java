class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] freq = new int[26];

        // Add s1
        for (char c : s1.toCharArray())
            freq[c - 'a']++;

        // Remove first window
        for (int i = 0; i < n; i++)
            freq[s2.charAt(i) - 'a']--;

        if (allZero(freq))
            return true;

        // Sliding window
        for (int i = n; i < m; i++) {
            freq[s2.charAt(i) - 'a']--;
            freq[s2.charAt(i - n) - 'a']++;

            if (allZero(freq))
                return true;
        }

        return false;
    }

    private boolean allZero(int[] freq) {
        for (int x : freq)
            if (x != 0)
                return false;
        return true;
    }
}