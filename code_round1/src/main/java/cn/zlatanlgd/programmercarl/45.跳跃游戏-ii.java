/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int curDistance = 0;
        int ans = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);
            if(i == curDistance){
                if (curDistance != nums.length) {
                    ans++;
                    curDistance = nextDistance;
                    if(nextDistance >= nums.length-1)
                        break;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

