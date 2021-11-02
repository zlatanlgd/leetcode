package cn.zlatanlgd.programmercarl;/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // int slowIndex = 0;
        // int fastIndex = 0;
        // int temp;
        // for (fastIndex = 0; fastIndex < nums.length; fastIndex++) {
        //     if(nums[slowIndex] == 0 && nums[fastIndex]!=0){
        //     temp = nums[slowIndex];
        //     nums[slowIndex] = nums[fastIndex];
        //     nums[fastIndex] = temp;
        //     slowIndex++;
        //     }else if(nums[slowIndex]!=0)
        //     slowIndex++;
        // }
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                while(index < i && nums[index] != 0) index++;
                int tem = nums[index];
                nums[index] = nums[i];
                nums[i] = tem;
            }
        }

    }
}
// @lc code=end
