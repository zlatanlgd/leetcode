import java.util.ArrayDeque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 迭代法 bfs
        if (root == null) {
            return root;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
        }
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    // 递归法 , dfs
    // public TreeNode invertTree(TreeNode root) {
    // if (root == null) {
    // return root;
    // }
    // treeSwap(root);
    // invertTree(root.right);
    // invertTree(root.left);
    // return root;
    // }

    // public void treeSwap(TreeNode root) {
    // TreeNode temp = root.left;
    // root.left = root.right;
    // root.right= temp;
    // }

}
// @lc code=end
