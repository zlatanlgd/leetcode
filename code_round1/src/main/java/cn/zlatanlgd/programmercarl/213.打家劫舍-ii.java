/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        int result1 = robRange(nums, 0, nums.length - 2);
        int result2 = robRange(nums, 1, nums.length - 1);
        return Math.max(result1, result2);
    }

    public int robRange(int[] nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left+1] = Math.max(nums[left],nums[left+1]);
        for(int i =2+left; i<=right; i++){
            dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1]);
        }
        return dp[right];
    }
}
// @lc code=end

