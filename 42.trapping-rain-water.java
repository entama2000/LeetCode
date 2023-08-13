/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
import java.util.*;
// @lc code=start
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int max = height[0];
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        int l = 0;
        int lmax = 0;
        int r = height.length - 1;
        int rmax = 0;
        while (l < r) {
            if (l < maxIndex) {
                if (height[l] > lmax) {
                    lmax = height[l];
                } else {
                    ans += lmax - height[l];
                }
                //System.out.println("l: " + l + " ans: " + ans);
                l++;
            }
            if (maxIndex < r) {
                if (height[r] > rmax) {
                    rmax = height[r];
                } else {
                    ans += rmax - height[r];
                }
                //System.out.println("r: " + r + " ans: " + ans);
                r--;
            }
        }
        return ans;
    }
}
// @lc code=end

