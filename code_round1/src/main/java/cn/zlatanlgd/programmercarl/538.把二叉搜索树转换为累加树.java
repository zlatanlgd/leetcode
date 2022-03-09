import java.util.Stack;

import javax.swing.tree.TreeNode;

import org.junit.validator.ValidateWith;

/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        //迭代法
        // int sum = 0;
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode cur = root;
        // while (cur != null || !stack.isEmpty()) {
        //     if (cur != null) {
        //         stack.push(cur);
        //         cur = cur.right; //右
        //     } else {
        //         cur = stack.pop();
        //         cur.val += sum;
        //         sum = cur.val;
        //         cur = cur.left;
        //     }
        // }
        // return root;
        //递归
        sum = 0;
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {
        if (root==null) {
            return;
        }
        traversal(root.right);
        sum += root.val;
        root.val = sum;
        traversal(root.left);
    }
}
// @lc code=end
