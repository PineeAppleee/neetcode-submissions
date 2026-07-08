class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pg = new int[n];
        pg[0] = height[0];
        for(int i = 1;i<n;i++){
            pg[i] = Math.max(height[i],pg[i-1]);
        }

        int[] ng = new int[n];
        ng[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            ng[i] = Math.max(height[i],ng[i+1]);
        }
         
         int totalwater = 0;
        for(int i = 0;i<n;i++){
            totalwater+= Math.min(pg[i],ng[i])-height[i];
        }
        return totalwater;
     }
}
