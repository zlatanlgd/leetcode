import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return buildTree(nums, 0, nums.length);

    }

    // 确定返回值
    public TreeNode buildTree(int[] nums, int left, int right) {
        // 终止条件
        if (right - left < 1) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        // 单层工作逻辑：找到最大值，用最大值索引划分左右数组。
        int maxVal = nums[left];
        int maxValIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxValIndex = i;
            }
        }
        TreeNode node = new TreeNode(maxVal);
        node.left = buildTree(nums, left, maxValIndex);
        node.right = buildTree(nums, maxValIndex + 1, right);
        return node;

    }
}
// @lc code=end
