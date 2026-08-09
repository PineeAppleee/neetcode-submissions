class Solution {
    HashSet<String> set = new HashSet<>();
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str : wordDict){
            set.add(str);
        }
        dp = new Boolean[s.length()];
        return rec(s,0,s.length());
    }
    public boolean rec(String s,int idx,int n){
        if(idx==n) return true;
        if(idx>n) return false;
        if(dp[idx]!=null) return dp[idx];
        boolean ans = false;
        for(int i = idx;i<n;i++){
          if(set.contains(s.substring(idx,i+1))){
           if(rec(s,i+1,n)){
            ans = true;
           }
          }
        }
        return dp[idx] = ans;
    }
}
