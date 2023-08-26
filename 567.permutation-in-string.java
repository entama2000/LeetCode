/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int[] mp1 = new int[26];
        int[] mp2 = new int[26];
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i < len; i++) {
            mp1[cint(s1.charAt(i))] += 1;
            mp2[cint(s2.charAt(i))] += 1;
        }
        String st1 = Arrays.toString(mp1);
        if (st1.equals(Arrays.toString(mp2))) return true;
        for (int i = len; i < s2.length(); i++) {
            mp2[cint(s2.charAt(i))] += 1;
            mp2[cint(s2.charAt(i - len))] -= 1;
            if (st1.equals(Arrays.toString(mp2))) return true;
        }
        return false;
    }
    public int cint(char c) {
        return (int)(c - 'a');
    }
}
// @lc code=end

