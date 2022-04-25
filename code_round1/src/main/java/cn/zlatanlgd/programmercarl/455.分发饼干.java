import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(g.length == 0 || s.length== 0)
            return 0;
        int count = 0;
        int index = s.length-1;
        for (int i = g.length-1; i >=0; i--) {
            if (index >=0 && s[index] >= g[i]) {
                count++;
                index--;
            }
        } 
        return count;
    }
}
// @lc code=end

