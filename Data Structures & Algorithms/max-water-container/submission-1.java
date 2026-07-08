class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
       int r = n - 1;
        int ans = 0;
     while (l < r) {

    ans = Math.max(ans,
        Math.min(heights[l], heights[r]) * (r - l));

    if (heights[l] < heights[r])
        l++;
    else
        r--;
      }
      return ans;
    }
}
