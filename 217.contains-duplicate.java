import java.util.*;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(Integer.valueOf(nums[i]))) {
                return true;
            } else {
                mp.put(Integer.valueOf(nums[i]), true);
            }
        }
        return false;
    }
}
// @lc code=end

