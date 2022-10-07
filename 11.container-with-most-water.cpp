/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int result = 0;
        int j = height.size() - 1;
        int h = 0;
        while(i < j) {
            h = min(height[i], height[j]);
            result = max(result, h * (j - i));
            while(height[i] <= h && i < j) i++;
            while(height[j] <= h && i < j) j--;
        }
        return result;
    }
};
// @lc code=end

