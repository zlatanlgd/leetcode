package cn.zlatanlgd.programmercarl;

import jdk.internal.util.xml.impl.ReaderUTF16;
import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        int right = x/2;
        while (left < right) {
            int mid = left + ((right - left + 1) / 2);
            if (mid > x / mid) {
                right = mid - 1; // [left, mid-1]
            } else {
                left = mid; // [mid,right]
            }
        }
        return left;
    }
}
// @lc code=end
