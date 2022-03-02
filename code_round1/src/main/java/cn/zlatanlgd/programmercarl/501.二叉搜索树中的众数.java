import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    Stack<TreeNode> stack;
    ArrayList<Integer> result;
    TreeNode pre;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        result = new ArrayList<>();
        traversal(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新
        if (count > maxCount) {
            result.clear();
            result.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            result.add(root.val);
        }
        pre = root;
        traversal(root.right);
    }

}
// @lc code=end
