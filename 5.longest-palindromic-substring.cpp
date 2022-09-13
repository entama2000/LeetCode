/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        int paln = 0;
        for(int i = s.length(); i >= 1; i--)
        {
            for(int j = 0; j <= s.length() - i; j++)
                if(palind(s.substr(j, i)))
                    return s.substr(j, i);
        }
        return 0;
    }

    bool palind(string str)
    {
        for(int i = 0; i < str.length()/2; i++)
            if(str[i] != str[str.length()-1-i])
                return false;
        return true;
    }
};
// @lc code=end

