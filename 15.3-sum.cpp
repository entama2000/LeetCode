/*
 * @lc app=leetcode id=15 lang=cpp
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size()-2; i++) {
            int front = i+1;
            int back = nums.size()-1;
            int target = -nums[i];
            while (front < back) {
                if (target < nums[front] + nums[back])
                    back--;
                else if (target > nums[front] + nums[back])
                    front++;
                else {
                    vector<int> triplet = {nums[i], nums[front], nums[back]};
                    res.push_back(triplet);
                    while (front < back && nums[front] == triplet[1])
                        front++;
                    while (front < back && nums[back] == triplet[2])
                        back--;
                }
            }
            while(i < nums.size()-2 && nums[i] == nums[i+1])
                i++;
        }
        return res;
    }
};
// @lc code=end

