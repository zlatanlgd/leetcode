package cn.zlatanlgd.programmercarl;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        // int[] res;
        int left = 0, top = 0, right = n - 1, bottom = m - 1;
        int i = 0;
        while (i <= m * n) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
                i++;
            }
            if(++top>bottom) break;
            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);
                i++;
            }
            if(--right<left) break;
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
                i++;
            }
            if(--bottom<top) break;
            for (int j = bottom; j >= top; j--) {
                res.add(matrix[j][left]);
                i++;
            }
            if(++left>right) break;
        }
        return res;
    }
}
// @lc code=end
