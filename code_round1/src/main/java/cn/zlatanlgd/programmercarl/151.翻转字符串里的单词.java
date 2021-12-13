/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start

class Solution {

    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
    // public String reverseWords(String s) {
    //     // 1.移除多余空格
    //     StringBuilder sb = removeExtraSpaces(s);
    //     // 2.反转字符串
    //     reverseString(sb, 0, s.length() - 1);
    //     // 3.单词反转
    //     reverseWord(sb);

    //     return sb.toString();
    // }

    // private StringBuilder removeExtraSpaces(String s) {
    //     int start = 0;
    //     int n = s.length() - 1;
    //     while (s.charAt(start) == ' ') {
    //         start++;
    //     }
    //     while (s.charAt(n) == ' ') {
    //         n--;
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     while (start <= n) {
    //         char c = s.charAt(start);
    //         if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
    //             sb.append(c);
    //         }
    //         start++;
    //     }
    //     return sb;

    // }

    // private void reverseString(StringBuilder sb, int start, int end) {
    //     while (start < end) {
    //         char tempC = sb.charAt(start);
    //         sb.setCharAt(start, sb.charAt(end));
    //         sb.setCharAt(end, tempC);
    //         start++;
    //         end--;
    //     }
    // }

    // private void reverseWord(StringBuilder sb) {
    //     int start = 0;
    //     int end = 1;
    //     int n = sb.length();
    //     while (start < n) {
    //         while (end < n && sb.charAt(end) != ' ') {
    //             end++;
    //         }
    //         reverseString(sb, start, end - 1);
    //         start = end + 1;
    //         end = start + 1;
    //     }
    // }
}

// @lc code=end
