package cn.zlatanlgd.programmercarl;
/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int s_flag = 0, t_flag = 0;
        while (true) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    s_flag++;
                    i--;
                } else if (s_flag > 0) {
                    s_flag--;
                    i--;
                } else
                    break;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    t_flag++;
                    j--;
                } else if (t_flag > 0) {
                    t_flag--;
                    j--;
                } else
                    break;

            }
            if (i < 0 || j < 0)
                break;
            if (s.charAt(i) != t.charAt(j))
                return false;
            i--;
            j--;
        }
        if (i == -1 && j == -1)
            return true;
        return false;
    }
}
// @lc code=end
