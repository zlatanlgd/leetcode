package cn.zlatanlgd.programmercarl;/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        while (left <= right) {
            if ((nums[left] * nums[left]) > (nums[right] * nums[right])) {
                res[i] = (nums[left] * nums[left]);
                ++left;
            } else {
                res[i] = (nums[right] * nums[right]);
                --right;
            }
            --i;
        }
        return res;
    }
}
// @lc code=end
