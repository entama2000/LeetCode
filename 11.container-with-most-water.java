/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int length = height.length;
        int max = -1;
        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r -l);
            max = Math.max(max, cur);
            if (height[l] < height[r]) {
                int pre = height[l];
                while (l < r && height[l] <= pre) {
                    l++;
                }
            } else {
                int pre = height[r];
                while (l < r && height[r] <= pre) {
                    r--;
                }
            }
        }
        return max;
    }
}
// @lc code=end

