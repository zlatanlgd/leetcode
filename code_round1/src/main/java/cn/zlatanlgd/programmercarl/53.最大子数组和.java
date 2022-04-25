/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int result = -10000;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = sum > result ? sum : result;
            sum = sum <= 0? 0 : sum;
        }
        return result;
    }
}
// @lc code=end
