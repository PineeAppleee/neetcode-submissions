class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end = 0;
        int start = 1;
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int ans = 0;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(caneatpiles(piles,h,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean caneatpiles(int[]piles, int h , int rate){
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + rate - 1) / rate;
        }

        return hours <= h;
    }
}
