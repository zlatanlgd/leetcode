import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 哈希表思想解法，此题最优解为滑动窗口。
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        char[] charP = p.toCharArray();
        char[] charS = s.toCharArray();
        Arrays.sort(charP);
        String strP = new String(charP);
        for (int i = 0; i <= s.length() - n; i++) {
            char[] sortS = Arrays.copyOfRange(charS, i, i + n);
            Arrays.sort(sortS);
            String strS = new String(sortS);
            if (strP.equals(strS)) {
                res.add(i);                
            }
        }
        return res;
    }
}
// @lc code=end
