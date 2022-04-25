/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <=1)
            return nums.length;
        int curDiff= 0;
        int preDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length -1; i++) {
           curDiff = nums[i+1] - nums[i];
           if((curDiff >0 && preDiff <=0) || (curDiff < 0 && preDiff >=0)){
               result++;
               preDiff = curDiff;
           }
        }
        return result;
    }
}
// @lc code=end

