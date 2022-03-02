import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    TreeNode pre;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        // 迭代法
        // if (root == null) {
        // return 0;
        // }
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode cur = root;
        // while (cur != null || !stack.isEmpty()) {
        // if (cur != null) {
        // stack.push(cur);
        // cur = cur.left; // 左
        // } else {
        // cur = stack.pop();
        // if (pre != null) { // 中
        // result = Math.min(result, cur.val - pre.val);
        // }
        // pre = cur;
        // cur = cur.right; // 右
        // }
        // }
        // return result;

        // 递归
        if (root == null) {
            return 0;
        }
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root==null) {
            return;
        }
        //left
        traversal(root.left);
        //mid
        if (pre!=null) {
            result=Math.min(result, root.val-pre.val);
        }
        pre = root;
        //right
        traversal(root.right);
    }
}
// @lc code=end
