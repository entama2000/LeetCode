import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, (long)target, 4, 0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, Long target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index >= nums.length) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, index);
        }
        for (int i = index; i < nums.length - k + 1; i++) {
            //System.out.println(target - nums[i]);
            ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
            if (temp != null) {
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private ArrayList<List<Integer>> twoSum(int[] nums, long target, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int l = index;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                res.add(temp);
                while (l < r && nums[l] == nums[l + 1])
                    l++;
                while (l < r && nums[r] == nums[r - 1])
                    r--;
                l++;
                r--;
            } else {
                //[1000000000,1000000000,1000000000,1000000000]\n-294967296
                if (l < r && nums[r] < target - nums[l]) {
                    //System.out.println("i++: " + (target - nums[l]));
                    l++;
                }
                if (l < r && nums[r] > target - nums[l]) {
                    //System.out.println("r--: " + (target - nums[l]));
                    r--;
                }
            }
        }
        return res;
    }
}
// @lc code=end

