/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
import java.util.*;
// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int a2 = (int)Integer.valueOf(st.pop());
                int a1 = (int)Integer.valueOf(st.pop());
                //System.out.println("a1 = " + a1 + " a2 = " + a2 + " a1 + a2 = " + (a1 + a2));
                st.push(String.valueOf(a1 + a2));
            } else if (s.equals("-")) {
                int a2 = (int)Integer.valueOf(st.pop());
                int a1 = (int)Integer.valueOf(st.pop());
                //System.out.println("a1 = " + a1 + " a2 = " + a2 + " a1 - a2 = " + (a1 - a2));
                st.push(String.valueOf(a1 - a2));
            } else if (s.equals("*")) {
                int a2 = (int)Integer.valueOf(st.pop());
                int a1 = (int)Integer.valueOf(st.pop());
                //System.out.println("a1 = " + a1 + " a2 = " + a2 + " a1 * a2 = " + (a1 * a2));
                st.push(String.valueOf(a1 * a2));
            } else if (s.equals("/")) {
                int a2 = (int)Integer.valueOf(st.pop());
                int a1 = (int)Integer.valueOf(st.pop());
                //System.out.println("a1 = " + a1 + " a2 = " + a2 + " a1 / a2 = " + (a1 / a2));
                st.push(String.valueOf(a1 / a2));
            } else {
                st.push(s);
            }
        }
        return (int)Integer.valueOf(st.pop());
    }
}
// @lc code=end

