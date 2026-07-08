class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        while(j<n){
          char ch = s.charAt(j);
          while(i<j&&set.contains(ch)){
            set.remove(s.charAt(i));
            i++;
          }
          set.add(ch);
          len = Math.max(len,set.size());
          j++;

        }
        return len;
    }
}
