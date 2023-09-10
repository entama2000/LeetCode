/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            //int j = 1;
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                //System.out.println("i:j: " + i + ":" + j + " stpeek: " + temperatures[st.peek()] + " tempi: " + temperatures[i]);
                ans[st.peek()] = i - st.peek();
                st.pop();
                //j++;
            }
            st.push(i);
        }
        return ans;
    }
}
// @lc code=end

