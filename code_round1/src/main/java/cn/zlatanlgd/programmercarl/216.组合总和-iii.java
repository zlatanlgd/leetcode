import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1, 0);
        return result;
    }

    public void backTracking(int k, int n, int startIndex, int sum) {
        // 终止条件:1.sum>k 2.path.size == n
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(k, n, i + 1, sum);
            // 回溯
            path.removeLast();
            // 回溯
            sum -= i;
        }

    }
}
// @lc code=end
