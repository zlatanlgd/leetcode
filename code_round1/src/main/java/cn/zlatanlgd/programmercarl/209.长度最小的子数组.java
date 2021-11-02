package cn.zlatanlgd.programmercarl;/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int subLength = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            //滑动窗口大法好
            while (sum >= target) {
                subLength = (right - left + 1);
                result = result < subLength ? result : subLength;
                sum -= nums[left++];
            }
        }
        return result;

    }
}
// @lc code=end
