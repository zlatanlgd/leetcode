package cn.zlatanlgd.programmercarl;

import javax.lang.model.util.ElementScanner6;

import sun.print.resources.serviceui;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };
        int left = search(true, nums, target);
        int right = search(false, nums, target);
        return new int[] {left,right};
    }

    /**
     * left则向左寻找第一个元素 right则向右寻找最后一个元素 二分法注意细节！
     */
    public int search(boolean isFindFirst, int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else {
                // 找到target，确定向左还是向右
                if (isFindFirst) {
                    // left
                    if (mid > 0 && nums[mid - 1] == target) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    // right
                    if (mid < nums.length - 1 && nums[mid + 1] == target) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end
