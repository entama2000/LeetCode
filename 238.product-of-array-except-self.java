/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--) {
            ans[i - 1] = ans[i - 1] * right;
            right *= nums[i - 1];
        }
        return ans;
    }
}
// @lc code=end

