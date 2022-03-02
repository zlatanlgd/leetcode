import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.print.FlavorException;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 迭代法
        /*
         * if (root == null) { return false; } Stack<TreeNode> stackNode = new
         * Stack<>(); Stack<Integer> stackVal = new Stack<>(); stackNode.push(root);
         * stackVal.push(root.val); while (!stackNode.isEmpty()) { TreeNode node
         * =stackNode.pop(); int sum = stackVal.pop(); if (node.left == null &&
         * node.right == null && sum == targetSum) { return true; } if (node.right !=
         * null) { stackNode.push(node.right); stackVal.push(node.right.val+sum); } if
         * (node.left != null) { stackNode.push(node.left);
         * stackVal.push(node.left.val+sum); } } return false;
         */

        // 递归

        if (root == null) {
            return false;
        }
        return traversal(root, targetSum - root.val);
    }

    public boolean traversal(TreeNode cur, int count) {
        if (cur.left == null && cur.right == null && count == 0) {
            return true;
        }
        if (cur.left == null && cur.right == null) {
            return false;
        }
        if (cur.left != null) {
            count -= cur.left.val;
            if (traversal(cur.left, count)) {
                return true;
            }
            count += cur.left.val;
        }
        if (cur.right != null) {
            count -= cur.right.val;
            if (traversal(cur.right, count)) {
                return true;
            }
            count += cur.right.val;
        }
        return false;
    }
}
// @lc code=end
