class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n || heights[stack.peek()] >= heights[i])) {

                int height = heights[stack.pop()];

                int leftSmaller = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftSmaller - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}