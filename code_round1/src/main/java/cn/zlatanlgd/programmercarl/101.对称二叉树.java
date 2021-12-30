import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.relation.RoleResult;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 迭代法
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.pollFirst();
            TreeNode rightNode = queue.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null && rightNode != null) {
                return false;
            } else if (leftNode != null && rightNode == null) {
                return false;
            } else if (leftNode.val != rightNode.val) {
                return false;
            }
            queue.addFirst(leftNode.left);
            queue.addFirst(leftNode.right);
            queue.addLast(rightNode.right);
            queue.addLast(rightNode.left);
        }
        return true;

    }
    // 递归法
    // public boolean isSymmetric(TreeNode root) {
    // if (root == null) {
    // return true;
    // }
    // return compare(root.left, root.right);
    // }

    // public Boolean compare(TreeNode left, TreeNode right) {
    // if (left == null && right == null) {
    // return true;
    // } else if (left != null && right == null) {
    // return false;
    // } else if (left == null && right != null) {
    // return false;
    // } else if (left.val != right.val) {
    // return false;
    // }
    // boolean outside = compare(left.left, right.right);
    // boolean inside = compare(left.right, right.left);
    // return outside && inside;
    // }

}
// @lc code=end
