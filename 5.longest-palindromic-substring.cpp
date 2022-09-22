/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
public:
    string longestPalindrome(string s) {
        
        string result;
        int len = s.length();
        queue<pair<int, int>> q;

        //1 char
        for(int i = 0; i < len; i++)
            q.push({i, 1});

        //2 chars
        for(int i = 0; i < len-1; i++)
            if(s[i] == s[i+1])
                q.push({i, 2});
        //0 1 2 3 4 5
        while(!q.empty())
        {
            pair<int, int> temp = q.front();
            q.pop();
            if(temp.first != 0)
                if(s[temp.first-1] == s[temp.first + temp.second])
                    q.push({temp.first-1, temp.second+2});

            if(q.empty())
                result = s.substr(temp.first, temp.second);
        }

        return result;


    }

};
// @lc code=end

