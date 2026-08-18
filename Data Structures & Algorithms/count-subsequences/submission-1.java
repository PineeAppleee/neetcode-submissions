class Solution {
    HashMap<String,Integer> mp = new HashMap<>();
    public int numDistinct(String s, String t) {
        return count(new StringBuilder(), s, t, 0);
    }
    public int count(StringBuilder str, String s, String t,int idx){
        if(str.toString().equals(t)){
            return 1;
        }
        if(idx>=s.length()){
            return 0;
        }
        String key = str.toString()+"#"+idx;
        if(mp.containsKey(key)) return mp.get(key);
        //if(dp[idx]!=-1) return dp[idx];

        str.append(s.charAt(idx));
        int pick = count(str,s,t,idx+1);
        str.deleteCharAt(str.length()-1);

        pick += count(str,s,t,idx+1);

        mp.put(key,pick);
        return  pick;
    }
}
