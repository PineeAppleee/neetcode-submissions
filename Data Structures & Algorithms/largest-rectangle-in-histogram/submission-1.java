class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int n = heights.length;

        int[] pg = new int[n];
        int[] ng = new int[n];

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            pg[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            ng[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int width = ng[i] - pg[i] - 1;
            ans = Math.max(ans, width * heights[i]);
        }

        return ans;
    }
}