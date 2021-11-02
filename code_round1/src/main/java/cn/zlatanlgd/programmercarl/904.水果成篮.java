package cn.zlatanlgd.programmercarl;/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1 || fruits.length == 2) {
            return fruits.length;
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        int flag_l = fruits[left], flag_r = fruits[right];
        // 双指针法。right指针遍历
        // flag_l装第一种水果，flag_r装第二种水果
        for (right = 0; right < fruits.length; right++) {
            // 满足条件的队列判断条件：新
            if (fruits[right] == flag_r || fruits[right] == flag_l) {
                // 更新长度的最大值
                ans = Math.max(ans, right - left + 1);
            } else {
                /**
                 * 不满足条件时：fruit[right]出现第三种水果 此时要更新left: 1. left=right-1 2. 向前找到第一个等于flag_l的left
                 * 3. 定位到想要的left
                 **/
                left = right - 1;
                flag_l = fruits[left];
                while (left >= 1 && fruits[left - 1] == flag_l)
                    left--;
                flag_r = fruits[right];
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
// @lc code=end
