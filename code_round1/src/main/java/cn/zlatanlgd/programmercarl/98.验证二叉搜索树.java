import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    TreeNode maxNode;

    public boolean isValidBST(TreeNode root) {
        // 确认返回值：布尔值，输入参数 root 递归本函数
        // 终止条件：
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        // 中
        if (maxNode != null && root.val <= maxNode.val) {
            return false;
        }
        maxNode = root;
        // 右边
        boolean right = isValidBST(root.right);
        return right && left;
    }
}
// @lc code=end
