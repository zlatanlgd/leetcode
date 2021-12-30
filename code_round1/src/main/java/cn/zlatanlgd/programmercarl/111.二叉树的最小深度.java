import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int deep = 0;
        if (root == null) {
            return deep;
        }
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            deep++;
            while (size > 0) {
                TreeNode node = que.poll();
                if (node.left == null && node.right== null) {
                    return deep;
                }
                if (node.left!=null) {
                    que.add(node.left);
                }
                if (node.right!=null) {
                    que.add(node.right);
                }
                size--;
            }
        }
        return deep;
    }
}
// @lc code=end
