import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        preorderDfs(root, targetSum, res, path);
        return res;
    }

    public void preorderDfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        if (root.left ==null && root.right == null && targetSum - root.val==0) {
            res.add(new ArrayList<>(path));
        }
        if (root.left!=null) {
            preorderDfs(root.left, targetSum-root.val, res, path);
            path.remove(path.size()-1);
        }
        if (root.right!=null) {
            preorderDfs(root.right, targetSum-root.val, res, path);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end
