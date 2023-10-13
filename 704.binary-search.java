/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */
import java.util.*;
// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }
    public int searchHelper(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (left >= right) {
            return -1;
        } else if (nums[mid] < target) {
            return searchHelper(nums, target, mid + 1, right);
        } else {
            return searchHelper(nums, target, left, mid - 1);
        }
    }
}
// @lc code=end

