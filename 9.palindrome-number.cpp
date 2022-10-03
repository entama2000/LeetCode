/*
 * @lc app=leetcode id=9 lang=cpp
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
public:
    bool isPalindrome(int x) {
        //char* c = itoa(x);
        string str = to_string(x);
        for(int i = 0; i < str.length(); i++)
        {
            if(str[i] != str[str.length()-1-i])
                return false;
        }
        return true;
    }
};
// @lc code=end

