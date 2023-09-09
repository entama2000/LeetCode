/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
import java.util.*;
// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        Deque<String> q = new LinkedList<>();
        q.push("(");
        while (!q.isEmpty()) {
            String str = q.pop();
            int num = count(str);
            if (num < n && num > (str.length() - num)) {
                q.push(str + "(");
                q.push(str + ")");
            } else if (num < n) {
                q.push(str + "(");
            } else {
                while (str.length() < 2 * n) {
                    str = str + ")";
                }
            }
            if (str.length() == 2 * n) ans.add(str);
        }
        return ans;
    }

    private int count(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') num ++;
        }
        return num;
    }
}
// @lc code=end

