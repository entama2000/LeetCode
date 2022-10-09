/*
 * @lc app=leetcode id=12 lang=cpp
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
public:
    string intToRoman(int num) {
        string s = "";
        int digit = 1;
        while (num != 0) {
            string subs = "";
            int num1 = num%10;
            string rom1, rom5, rom10;
            //check Roman Symbol
            if (digit == 1) {
                rom1 = "I";
                rom5 = "V";
                rom10 = "X";
            } else if (digit == 2) {
                rom1 = "X";
                rom5 = "L";
                rom10 = "C";
            } else if (digit == 3) {
                rom1 = "C";
                rom5 = "D";
                rom10 = "M";
            } else if (digit == 4) {
                rom1 = "M";
                rom5 = "E5";
                rom10 = "E10";
            }
            //make sub num1
            if (num1 < 4) {
                for (int i = 0; i < num1; i++)
                    subs = subs + rom1;
            } else if (num1 == 4) {
                subs = rom1 + rom5;
            } else if (num1 < 9) {
                subs = rom5;
                for (int i = 0; i < num1 - 5; i++) 
                    subs = subs + rom1;
            } else if (num1 == 9) {
                subs = rom1 + rom10;
            }
            cout << rom1 << " " << rom5 << " " << rom10 << " " << subs << endl;
            cout << s << endl;
            s = subs + s;
            num = num / 10;
            digit++;
        }
        return s;
    }
};
// @lc code=end

