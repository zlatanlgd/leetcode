import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, int sum, int startindex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i <= candidates.length - 1; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
