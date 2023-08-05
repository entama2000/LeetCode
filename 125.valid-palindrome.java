/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left))) && left < right) {
                left++;
            }
            while (!(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right))) && left < right) {
                right--;
            }
            //System.out.println(left + " : " + right);
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

