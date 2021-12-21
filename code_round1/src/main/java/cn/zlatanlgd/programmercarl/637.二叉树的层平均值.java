import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return list; 
        }
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            int n = len;
            Double sum=0.0;
            while (len>0) {
                TreeNode tempNode = que.poll();
                sum += tempNode.val;
                if (tempNode.left!=null) {
                    que.add(tempNode.left);
                }
                if (tempNode.right!=null) {
                    que.add(tempNode.right);
                }
                len--;
            } 
            list.add(sum/n);
        } 
        return list;
    }
}
// @lc code=end

