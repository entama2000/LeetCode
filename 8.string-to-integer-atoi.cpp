/*
 * @lc app=leetcode id=8 lang=cpp
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string s) {
        s += 's';
        string result;
        int index = 0;
        int max{0}, min{0};
        bool neg = 0;
        while(s[index] == ' ')
            index++;
        if(s[index] == '-')
        {
            neg = 1;
            index++;
        }
        else if(s[index] == '+')
            index++;
        while(s[index]-'0' == 0)
            index++;
        while(s[index]-'0' < 10 && s[index] - '0' >= 0)
        {
            cout << s[index]-'0';
            //string sc{s[index]-'0'};
            result += s[index];
            cout << " " << result << endl;
            if(result.length() == 9)
            {
                
                if((s[index+1]-'0' < 10 && s[index+1] - '0' >= 0))
                {
                    int num = s[index+1]-'0';
                    if(neg == 0)
                    {
                        if(atoi(result.c_str()) > INT_MAX/10 || (atoi(result.c_str()) == INT_MAX/10 && num > 6))
                            max = 1;
                    }
                    else
                    {
                        if(atoi(result.c_str()) > (-1)*(INT_MIN/10) || (atoi(result.c_str()) == (-1)*(INT_MIN/10) && num > 7))
                            min = 1;
                    }       
                }
            }
            if(result == "0" || result.length() > 10 || max == 1 || min == 1)
            {
                if(result.length() > 10 && neg == 1) min = 1;
                else if(result.length() > 10 && neg == 0) max = 1;
                result = '0';
                break;
            }
            index++;
        }
        cout << "neg:" << neg <<" max:" << max << " min:" << min << endl;
        int resultInt = 0;
        resultInt = atoi(result.c_str());
        if(neg == 1) resultInt *= -1;
        if(max == 1) resultInt = INT_MAX;
        if(min == 1) resultInt = INT_MIN;
        return resultInt;
    }
};
// @lc code=end

