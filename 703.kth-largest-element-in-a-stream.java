/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            q.add(num);
        }
        while (q.size() > k) {
            q.remove();
        }
    }
    
    public int add(int val) {
        q.add(val);
        while (q.size() > k) {
            q.remove();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

