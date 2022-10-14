/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string s = "";
        if (strs.size() == 1)
            return strs[0];
        for (int i = 0; i < min(strs[0].length(), strs[1].length()); i++) {
            if (strs[0][i] == strs[1][i]) {
                s += strs[0][i];
            } else {
                break;
            }
        }
        //012345
        //abcdee
        //abcsdd
        for (int i = 2; i < strs.size(); i++) {
            int len = min(strs[i].length(), s.length());
            for (int j = 0; j < len; j++) {
                if (strs[i][j] == s[j]) {
                } else {
                    s = s.substr(0, j);
                }
            }
            s = s.substr(0, len);
        }
        return s;
    }
};
// @lc code=end

