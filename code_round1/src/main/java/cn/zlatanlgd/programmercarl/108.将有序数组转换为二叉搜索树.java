import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
// @lc code=end
