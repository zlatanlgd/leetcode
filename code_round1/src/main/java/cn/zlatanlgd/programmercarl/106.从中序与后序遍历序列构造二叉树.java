import java.util.PrimitiveIterator.OfDouble;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright) {
        // 为 空
        if (inright - inleft < 1) {
            return null;
        }

        //只有一个了
        if (inright - inleft == 1) {
            return new TreeNode(inorder[inleft]);
        }
        // 后续遍历的最后一个元素，就是当前的中间节点
        int rootVal = postorder[postright- 1];
        TreeNode root = new TreeNode(rootVal);

        // 找切割点
        int rootindex = 0;
        for (int i = inleft; i < inright; i++) {
            if (inorder[i] == rootVal) {
                rootindex = i;
                break;
            }
        }
        root.left = buildTree1(inorder, postorder, inleft, rootindex, postleft, postleft + (rootindex - inleft));
        root.right = buildTree1(inorder, postorder, rootindex + 1, inright, postleft + (rootindex - inleft),
                postright - 1);

        return root;
    }
}
// @lc code=end
