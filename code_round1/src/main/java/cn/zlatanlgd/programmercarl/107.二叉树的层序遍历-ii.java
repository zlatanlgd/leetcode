import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levList = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root==null) {
            return levList;
        }
        que.offer(root);
        
        while (!que.isEmpty()) {
            List<Integer> tempList=  new ArrayList<>();
            int len = que.size();
            while (len>0) {
                TreeNode tmpNode = que.poll();
                tempList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }    
            levList.add(tempList);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = levList.size()-1; i >=0 ; i--) {
           resList.add(levList.get(i));
        }
        return resList;
    }
}
// @lc code=end

