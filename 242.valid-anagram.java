/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            if (mp.containsKey(Character.valueOf(c))) {
                mp.put(Character.valueOf(c), Integer.valueOf(mp.get(c) + 1));
            } else {
                mp.put(Character.valueOf(c), 1);
            }
            
        }
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            if (tmp.containsKey(Character.valueOf(c))) {
                tmp.put(Character.valueOf(c), Integer.valueOf(tmp.get(c) + 1));
            } else {
                tmp.put(Character.valueOf(c), 1);
            }
        }
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            if (!e.getValue().equals(tmp.get(e.getKey()))) {
                return false;
            }
        }
        return true;
    }
    
}
// @lc code=end

