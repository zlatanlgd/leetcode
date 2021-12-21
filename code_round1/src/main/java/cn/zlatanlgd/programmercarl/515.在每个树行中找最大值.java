import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return list; 
        }
        que.addLast(root);
        while (!que.isEmpty()){
            int levelSize = que.size();
            int max=que.peek().val;
            while (levelSize>0) {
                TreeNode tempNode = que.pollFirst();
                if (tempNode.val > max) {
                    max = tempNode.val;
                } 
                if (tempNode.left != null) {
                    que.addLast(tempNode.left); 
                }
                if (tempNode.right != null) {
                    que.addLast(tempNode.right); 
                }
                levelSize--;
            } 
            list.add(max);
        }
        return list;
    }
}
// @lc code=end

