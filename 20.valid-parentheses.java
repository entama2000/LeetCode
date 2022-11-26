import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        char cs[] = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')' && stack.size() != 0 && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.size() != 0 && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.size() != 0 && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
// @lc code=end

