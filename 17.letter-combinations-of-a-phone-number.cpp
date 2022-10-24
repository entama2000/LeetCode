/*
 * @lc app=leetcode id=17 lang=cpp
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        int len = digits.length();
        queue<string> q;
        map<char, string> m;
        m['2'] = "abc";
        m['3'] = "def";
        m['4'] = "ghi";
        m['5'] = "jkl";
        m['6'] = "mno";
        m['7'] = "pqrs";
        m['8'] = "tuv";
        m['9'] = "wxyz";
        cout << m[digits[0]].length() << endl;
        for (int i = 0; i < m[digits[0]].length(); i++) {
            string s = "";
            s.push_back(m[digits[0]][i]);
            q.push(s);
        }
        while (len != 0 && q.front().length() < len) {
            int i = q.front().length();
            for (int j = 0; j < m[digits[i]].length(); j++) {
                string s = q.front();
                s.push_back(m[digits[i]][j]);
                q.push(s);
            }
            q.pop();
        }
        while (!q.empty()) {
            result.push_back(q.front());
            q.pop();
        }
        return result;
    }
};
// @lc code=end