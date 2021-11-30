/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (record[c - 'a'] == 0)
                return false;
            record[c - 'a']--;
        }

        return true;
    }
}
// @lc code=end
