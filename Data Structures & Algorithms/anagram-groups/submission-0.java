class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<Integer>> mp = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            List<Integer> list = new ArrayList<>();
            if(mp.containsKey(str)){
                list = mp.get(str);
                list.add(i);
                mp.put(str,list);
            }else{
                list.add(i);
                mp.put(str,list);
            }
        }
        List<List<String>> l = new ArrayList<>();
        for(String key : mp.keySet()){
            List<Integer> list = mp.get(key);
            List<String> temp = new ArrayList<>();
            for(int i = 0;i< list.size();i++){
                temp.add(strs[list.get(i)]);
            }
            l.add(temp);
        }
        return l;
    }
}
