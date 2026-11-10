class Solution {
    public int maxArea(int[] heights) {
        int sp = 0;
        int ep = heights.length - 1;
        int maxarea = 0;

        while (sp < ep) {
            int height = Math.min(heights[sp], heights[ep]);
            int width = ep - sp;
            int area = height * width;

            maxarea = Math.max(maxarea, area);

            if (heights[sp] >= heights[ep]) {
                ep--;
            } else {
                sp++;
            }
        }

        return maxarea;
    }
}