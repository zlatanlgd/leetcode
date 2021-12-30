import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // public int sumOfLeftLeaves(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }
    // Stack<TreeNode> stack = new Stack<>();
    // stack.add(root);
    // int result = 0;
    // while (!stack.isEmpty()) {
    // TreeNode node = stack.pop();
    // if (node.left != null && node.left.left == null && node.left.right == null) {
    // result += node.left.val;
    // }
    // if (node.right != null) {
    // stack.add(node.right);
    // }
    // if (node.left != null) {
    // stack.add(node.left);
    // }
    // }
    // return result;
    // }

    // 递归
    public int sumOfLeftLeaves(TreeNode root) {
        // 确定终止条件
        if (root == null) {
            return 0;
        }
        // 传入参数：节点
        // 传出参数：左叶子节点的值
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midVal = 0;
        // 定义每次递归的操作逻辑
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midVal = root.left.val;
        }
        int sum = midVal + leftValue + rightValue;
        return sum;
    }
}
// @lc code=end
