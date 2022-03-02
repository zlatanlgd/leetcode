/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 确认终止条件
        if (root == null) {
            return root;
        }
        /**
         * 确认单层逻辑 1.没查找到删除的节点，遍历到空返回 2.要删除的节点的左右节点都是null：直接删除该节点，返回Null
         * 3.要删除的节点的左孩子为空，右孩子不为空：右孩子补位，返回右孩子为根节点 4.要删除的节点的右孩子为空，左孩子不为空，返回左孩子为根节点
         * 5.要删除的节点左右孩子都不为空：将删除节点的左孩子放到删除节点的右子树的最左边节点的左孩子上，返回删除节点右孩子为新的根节点。
         */
        if (root.val == key) {
            // 2.都是null
            if (root.left == null && root.right == null) {
                return null;
            } // 3
            else if (root.left == null && root.right != null) {
                return root.right;
            } // 4
            else if (root.left != null && root.right == null) {
                return root.left;
            } // 5
            else if (root.left != null && root.right != null) {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
// @lc code=end
