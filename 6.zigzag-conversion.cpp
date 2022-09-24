/*
 * @lc app=leetcode id=6 lang=cpp
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
public:
    string convert(string s, int numRows) {
        string result = "";
        if(numRows == 1 || s.length() < numRows)
            return s;
        else
        {
            int oneSet = numRows + numRows - 2;
            //first line
            for(int i = 0; i*oneSet < s.length(); i++)
                result += s[i*oneSet];

            //middle lines
            for(int row = 1; row < numRows-1; row++)
            {
                int upper = row*2 - 1; // 1 3 5 7 ...
                int lower = (numRows-1-row)*2 - 1;
                int index = row;
                int isUpper = 0;
                do
                {
                    result += s[index];
                    if(isUpper%2 == 0)
                        index += (lower+1); // lower
                    else
                        index += (upper+1); // upper
                    isUpper++;
                } while (index < s.length());
            }

            //last line
            for(int i = 0; i*oneSet + numRows - 1 < s.length(); i++)
                result += s[i*oneSet + numRows - 1];

            return result;
        }
    }
};
// @lc code=end

