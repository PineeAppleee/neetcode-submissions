class Solution {
    HashMap<String,Integer> mp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0,0);
    }
    public int rec(int[] nums,int target,int idx,int tsum){
        
        if(idx>=nums.length){
            if(target==tsum) return 1;
            return 0;
        }
        String str = idx+"#"+tsum;
        if(mp.containsKey(str)) return mp.get(str);
         int ways = 0;
         ways = rec(nums,target,idx+1,tsum+nums[idx]);
         ways += rec(nums,target,idx+1,tsum-nums[idx]);
         mp.put(str,ways);
        return ways;
    }
}
