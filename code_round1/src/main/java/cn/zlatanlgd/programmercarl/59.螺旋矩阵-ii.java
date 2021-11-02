package cn.zlatanlgd.programmercarl;/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        /**
         * 思路： 1. 定义left,right,top,botton为当前矩阵边界 2. 循环次数为n*n 3. 一圈循环分为四个步骤，→↓←↑ 4.
         * 一圈结束后,起始位置应为：res[l][t]
         * 
         */
        int left = 0, top = 0, right = n - 1, botton = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int i = left; i <= right; i++)
                res[top][i] = num++;
            top++;
            for (int i = top; i <= botton; i++)
                res[i][right] = num++;
            right--;
            for (int i = right; i >= left; i--)
                res[botton][i] = num++;
            botton--;
            for (int i = botton; i >= top; i--)
                res[i][left] = num++;
            left++;
        }
        return res;
    }
}
// @lc code=end
