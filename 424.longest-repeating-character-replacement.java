/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */
import java.util.*;
// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int[] maxes = new int[26];
        int max = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = pint(s.charAt(i));
            maxes[num] += 1;
            if (maxes[num] > max) {
                max = maxes[num];
            }
            if (i - l + 1 - max > k) {
                maxes[pint(s.charAt(l))]--;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
            //System.out.println("i: " + i + " l: " + l + " ans: " + ans);
        }
        return ans;
    }
    public int pint(char c) {
        return (int)(c - 'A');
    }
}
// @lc code=end

