import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= index + (candidates.length - 1); i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], index + 1);
            path.remove(path.size() - 1);
        }

    }
}
// @lc code=end
