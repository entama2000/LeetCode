/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) set.add(Integer.valueOf(n));
        int max = 0;
        int i = 0;
        while (!set.isEmpty()) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                int count = 1;
                int right = nums[i] + 1;
                int left = nums[i] - 1;
                while (set.contains(right)) {
                    count++;
                    set.remove(right);
                    right++;
                }
                while (set.contains(left)) {
                    count++;
                    set.remove(left);
                    left--;
                }
                max = Math.max(max, count);
            }
            i++;
        }
        return max;
    }
}
// @lc code=end

