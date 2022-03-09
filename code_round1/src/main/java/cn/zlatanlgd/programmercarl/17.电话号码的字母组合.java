import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        String[] numString = { "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
        };
        backTracking(digits, numString, 0);
        return list;
    }

    public void backTracking(String digits, String[] numString, int num) {
        // 终止条件:遍历完digits的所有数字, num == digits.length
        if (num == digits.length()) {
            list.add(sb.toString());
            return;
        }
        // str 当前num代表的字符串
        // 数组的索引值自动转换为int类型。
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end
