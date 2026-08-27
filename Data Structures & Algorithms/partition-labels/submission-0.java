class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,List<Integer>> mp = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = i;
           mp.computeIfAbsent(ch, k -> new ArrayList<>(List.of(idx,idx)));
           mp.get(ch).set(1,i);
        }
        int ch1 = 0;
        int ch2 = -1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            List<Integer> list= mp.get(ch);
            if(ch2<list.get(1)){
                ch2 = list.get(1);
            }
            if(ch2==i){
                int ans = i-ch1+1;
               res.add(ans);
               ch1 = ch2+1;
            }
        }
        return res;
    }
}
