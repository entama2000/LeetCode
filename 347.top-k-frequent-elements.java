/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (!mp.containsKey(num)) {
                mp.put(num, 1);
            } else {
                mp.put(num, mp.get(num) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> item : mp.entrySet()) {
            pq.add(item);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        //System.out.println(Arrays.toString(ans));
        return ans;
    }

    
}
// @lc code=end

