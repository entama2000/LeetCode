/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
import java.util.*;
// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        Queue<Character> que = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            while (mp.containsKey(c)) {
                Character dc = que.poll();
                mp.remove(dc);
            }
            mp.put(c, 1);
            que.add(c);
            max = Math.max(max, que.size());
        }
        return max;
    }
}
// @lc code=end

