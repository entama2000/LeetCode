/*
 * @lc app=leetcode id=7 lang=cpp
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
public:
    int reverse(int x) {
        bool neg;
        if(x < 0) neg = true;
        else neg = false;

        string intNegMax = "2147483648";
        string intPosMax = to_string(abs(INT_MAX));

        string s = to_string(x);
        string result((int)(s.length()-1), ' ');
        if(!neg)
        {
            result = to_string(x);
            for(int i = 0; i < s.length(); i++)
                result[i] = s[s.length()-1-i];
        }
        else
            for(int i = 0; i < s.length()-1; i++)
                result[i] = s[s.length()-1-i];

        //negative
        //1234567
        //1234568
        //1234565
        bool bigger = false;
        if(neg && result.length() == 10)
        {
            cout << intNegMax << endl;
            for(int i = 0; result.length(); i++)
            {
                if(intNegMax[i] == result[i])
                    continue;
                else if(intNegMax[i] < result[i])
                {
                    bigger = true;
                    break;
                }
                else if(intNegMax[i] > result[i])
                    break;
            }
        }
        //positive
        else if(!neg && result.length() == 10)
        {
            cout << intPosMax << endl;
            for(int i = 0; result.length(); i++)
            {
                if(intPosMax[i] == result[i])
                    continue;
                else if(intPosMax[i] < result[i])
                {
                    bigger = true;
                    break;
                }
                else if(intPosMax[i] > result[i])
                    break;
            }
        }

        cout << "neg:" << neg << " result:" << result 
        << " bigger:" << bigger << endl;

        int resultInt = 0;

        if(neg)
            result = "-" + result;
        if(!bigger)
            resultInt = stoi(result);

        return resultInt;
    }
};
// @lc code=end

