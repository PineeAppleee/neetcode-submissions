class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        for(int key : mp.keySet()){
            int val = mp.get(key);
            if(val>1) return true;
        }
        return false;
    }
}