import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
        if (inleft > inright || preleft > preright) {
            return null;
        }

        int rootVal = preorder[preleft];
        TreeNode root = new TreeNode(rootVal);

        int rootindex = 0;
        for (int i = inleft; i <= inright; i++) {
            if (inorder[i] == rootVal) {
                rootindex = i;
                break;
            }
        }

        //关键理解1：中序左区间的长度应该为：rootindex - inleft
        //关键理解2：区间原则应当保持一致！
        root.left = buildTree1(preorder, inorder, preleft + 1, preleft + rootindex - inleft, inleft, rootindex - 1);
        root.right = buildTree1(preorder, inorder, preleft + (rootindex - inleft) + 1, preright, rootindex + 1,
                inright);
        return root;
    }
}
// @lc code=end
