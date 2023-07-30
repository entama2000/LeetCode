/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Character, Integer>> list = new LinkedList<>();
        for(String str : strs) {
            list.add(makeMap(str));
        }
        int[] a = new int[strs.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        int ind = 1;
        for (int i = 0; i < list.size(); i++) {
            Map<Character, Integer> curMap = list.get(i);
            if (a[i] != 0) {
                continue;
            }
            //System.out.println(ind);
            int k = -1;
            for (Map<Character, Integer> curMap2 : list) {
                k++;
                if (a[k] != 0) {
                    continue;
                } else if (curMap.equals(curMap2)) {
                    a[k] = ind;
                }
            }
            ind++;
        }
        //System.out.println(Arrays.toString(a) + " : " + ind);
        List<List<String>> ans = new LinkedList<>();
        for (int i = 0; i < ind - 1; i++) {
            ans.add(new LinkedList<>());
        }
        for (int i = 0; i < a.length; i++) {
            ans.get(a[i]-1).add(strs[i]);
        }
        /*for (List<String> st : ans) {
            for (String st2 : st) {
                System.out.print(st2 + " ");
            }
            System.out.println();
        }*/

        return ans;
    }


    private Map<Character, Integer> makeMap(String str) {
        Map<Character, Integer> mp = new HashMap<>();
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            char c = str.charAt(i);
            if (mp.containsKey(Character.valueOf(c))) {
                mp.put(Character.valueOf(c), Integer.valueOf(mp.get(c) + 1));
            } else {
                mp.put(Character.valueOf(c), 1);
            }
        }
        return mp;
    }
}
// @lc code=end

