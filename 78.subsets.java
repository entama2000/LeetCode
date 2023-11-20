/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
import java.util.*;
// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        int max = 1;
        for (int i = 0; i < len; i++) {
            max *= 2;
        }
        max -= 1;
        for (int i = 0; i <= max; i++) {
            List<Integer> cur = new LinkedList<>();
            int cover = 1;
            for (int j = 1; j <= 10; j++) {
                /**System.out.println(i);
                System.out.println(cover);
                System.out.println(i & cover);**/
                if ((i & cover) != 0) {
                    cur.add(nums[j-1]);
                }
                cover *= 2;
            }
            ans.add(cur);
        }
        return ans;
    }
}
// @lc code=end

