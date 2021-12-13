import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // 递归法
    // public List<Integer> postorderTraversal(TreeNode root) {
    // List<Integer> result = new ArrayList<>();
    // postOrder(root, result);
    // return result;
    // }

    // void postOrder(TreeNode root,List<Integer> list) {
    // if (root == null) {
    // return;
    // }
    // postOrder(root.left, list);
    // postOrder(root.right, list);
    // list.add(root.val);
    // }

    // 迭代法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        //期望输出：左 右 根
        stack.push(root);
        //入栈：根 左 右
        //输出数组：根 右 左  ----> 反转为： 左 右 根
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end
