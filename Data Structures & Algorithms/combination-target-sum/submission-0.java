class Solution {
    List<List<Integer>> unique = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        rec(nums,target,new ArrayList<>(),0);
        return unique;
    }
    public void rec(int[] nums,int target,List<Integer> list,int idx){
      if(target==0){
        unique.add(new ArrayList<>(list));
        return;
       }

       if(idx>=nums.length) return;
       
       if(target>0&&target>=nums[idx]){
        list.add(nums[idx]);
        rec(nums,target-nums[idx],list,idx);
        list.remove(list.size()-1);
       }

       rec(nums,target,list,idx+1);
    }
}
