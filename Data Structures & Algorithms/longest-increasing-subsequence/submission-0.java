class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = 0;
        int tails[] = new int[nums.length];
        
        for(int num : nums){
            int left = 0;
            int right = size ;

            while(left<right){
                int mid = left+(right-left)/2;
                if(num<=tails[mid]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            tails[left] = num;

            if(left==size){
                size++;
            }
        }
        return size;
    }
}
