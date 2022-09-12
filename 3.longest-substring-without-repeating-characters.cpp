/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
#include <stack>
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        queue<char> st;
        map<char, int> mp;
        int max;

        for(int i = 0; i < s.length(); i++)
        {
            //char not in s
            if(mp[s[i]] != 1)
            {
                st.push(s[i]);
                mp[s[i]] = 1;
            }
            //char in s
            else
            {
                int num = 0;
                int size = st.size();
                char c;
                do
                {
                    c = st.front();
                    mp[c] = 0;
                    st.pop();
                    num++;
                } while(c != s[i]);
                if(max <= size)
                    max = size;
                st.push(s[i]);
                mp[s[i]] = 1;
                
            }
        }
        int numlast = 0;
        while(!st.empty())
        {
            //cout << st.front() << endl;
            numlast++;
            st.pop();
        }
        if(max <= numlast)
            max = numlast;

        return max;
    }
};
// @lc code=end

