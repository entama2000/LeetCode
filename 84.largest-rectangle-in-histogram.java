/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */
import java.util.*;
// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = -1;
        Stack<Integer> indexSt = new Stack<>();
        Stack<Integer> heightSt = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int curh = heights[i];
            int start = i;
            while (!heightSt.isEmpty() && heightSt.peek() > curh) {
                int index = indexSt.pop();
                int height = heightSt.pop();
                max = Math.max(max, height * (i - index));
                start = index;
            }
            indexSt.push(start);
            heightSt.push(curh);
        }
        while (!indexSt.isEmpty()) {
            int index = indexSt.pop();
            int height = heightSt.pop();
            max = Math.max(max, height * (heights.length - index));
        }
        return max;
    }
}
// @lc code=end

