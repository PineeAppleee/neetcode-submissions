class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        rec(nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    public void rec(int[] nums, List<Integer> perm,boolean[] pick){
        if(perm.size()==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(!pick[i]){
                perm.add(nums[i]);
                pick[i] = true;
                rec(nums,perm,pick);
                perm.remove(perm.size()-1);
                pick[i] = false;
            }
        }   
    }
}
