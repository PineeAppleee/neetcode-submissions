class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(nums,0,new ArrayList<>());
        return res;
    }
    public void rec(int[] nums, int idx, List<Integer> subset) {
        res.add(new ArrayList<>(subset));
        for (int j = idx; j < nums.length; j++) {
            if (j > idx && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            rec(nums, j + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
