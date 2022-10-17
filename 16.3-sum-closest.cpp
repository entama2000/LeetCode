/*
 * @lc app=leetcode id=16 lang=cpp
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int absn = abs(target-res);
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i++) {
            int l = i + 1;
            int r = nums.size() - 1;
            int sum = nums[i] + nums[l] + nums[r];
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int sa = abs(target-sum);
                if (sa < absn) {
                    absn = sa;
                    res = sum;
                }
                if (sum < target) l++;
                else if (sum > target) r--;
                else {
                    absn = 0;
                    res = sum;
                    return sum;
                }
                //cout << "absn: " << absn << " sa: " << sa << " res: " << res
            //<< " sum: " << sum << endl;
            }
            while(i < nums.size()-2 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
};
// @lc code=end

