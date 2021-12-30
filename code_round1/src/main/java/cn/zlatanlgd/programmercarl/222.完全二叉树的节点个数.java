/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = getNodesNum(root.left);
        int rightNum = getNodesNum(root.right);
        int treeNum = leftNum + rightNum + 1;
        return treeNum;
    }

    public int getNodesNum(TreeNode node) {
        return countNodes(node);
    }
}
// @lc code=end
