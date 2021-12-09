/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        // if (ch.length==1) {
        //     return s;
        // }
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length-1, start + k - 1);
            reverse(ch, start, end);
        }
        return new String(ch);

    }

    public void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp;
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end
