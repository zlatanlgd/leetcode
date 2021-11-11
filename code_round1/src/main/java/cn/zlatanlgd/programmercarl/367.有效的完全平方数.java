package cn.zlatanlgd.programmercarl;
/*
* @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public static void main(String[] args) {
        boolean falg = isPerfectSquare(5);
        System.out.println(falg);
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 1;
        int right = num / 2;
        while (left < right) {
            int mid = left + ((right - left + 1) / 2);
            if (mid > num / mid) {
                right = mid - 1; // [left, mid-1]
            } else if (mid * mid == num) {
                return true;
            } else {
                left = mid; // [mid,right]
            }
        }
        return false;
    }
}

// @lc code=end