import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = new String(charArray);
            if (maps.containsKey(sortStr)) {
                maps.get(sortStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                maps.put(sortStr, list);
            }
        }
        return new ArrayList<>(maps.values());
    }
}
// @lc code=end
