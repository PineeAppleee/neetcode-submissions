class Solution {
    List<List<Integer>> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        rec(new ArrayList<>(),new HashSet<>(),0,nums);
        return subset;
    }
    public void rec(List<Integer> list,HashSet<List<Integer>> set,int idx,int nums[]){
        if(idx>=nums.length){
            if(!set.contains(list)){
                subset.add(new ArrayList<>(list));
            }
            set.add(list);
            return;
        }
         
        list.add(nums[idx]);
        rec(list,set,idx+1,nums);
         list.remove(list.size()-1);
        rec(list,set,idx+1,nums);
       
    }
}
